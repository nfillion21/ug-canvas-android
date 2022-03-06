package pgm.poolp.ugcanvas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import pgm.poolp.ugcanvas.utilities.DATABASE_NAME
import pgm.poolp.ugcanvas.utilities.PLAYERS_DATA_FILENAME
import pgm.poolp.ugcanvas.utilities.PLAYERS_TEAMS_DATA_FILENAME
import pgm.poolp.ugcanvas.utilities.TEAMS_DATA_FILENAME
import pgm.poolp.ugcanvas.workers.PlayersDatabaseWorker
import pgm.poolp.ugcanvas.workers.PlayersDatabaseWorker.Companion.PLAYERS_KEY_FILENAME
import pgm.poolp.ugcanvas.workers.PlayersTeamsDatabaseWorker
import pgm.poolp.ugcanvas.workers.PlayersTeamsDatabaseWorker.Companion.PLAYERS_TEAMS_KEY_FILENAME
import pgm.poolp.ugcanvas.workers.TeamsDatabaseWorker
import pgm.poolp.ugcanvas.workers.TeamsDatabaseWorker.Companion.TEAMS_KEY_FILENAME

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */
@Database(entities = [Player::class, Team::class, PlayerTeamCrossRef::class], version = 1, exportSchema = false)
abstract class UGCanvasRoomDatabase : RoomDatabase() {

    abstract fun playersDAO(): PlayersDAO
    abstract fun teamsDAO(): TeamDAO
    abstract fun playersTeamsCrossRefDAO(): PlayersTeamsCrossRefDAO

    companion object {
        @Volatile
        private var instance: UGCanvasRoomDatabase? = null

        fun getInstance(context: Context): UGCanvasRoomDatabase {
            return instance ?: synchronized(this)
            {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): UGCanvasRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                UGCanvasRoomDatabase::class.java,
                DATABASE_NAME
            )
                // Wipes and rebuilds instead of migrating if no Migration object.
                // Migration is not part of this codelab.
                //.fallbackToDestructiveMigration()
                .addCallback(WorkersDatabaseCallback(context))
                .build()
        }

        private class WorkersDatabaseCallback(
            private val context: Context
        ) : RoomDatabase.Callback() {
            /**
             * Override the onCreate method to populate the database.
             */
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                val workManager = WorkManager.getInstance(context)

                val requestPlayers = OneTimeWorkRequestBuilder<PlayersDatabaseWorker>()
                    .setInputData(workDataOf(PLAYERS_KEY_FILENAME to PLAYERS_DATA_FILENAME))
                    .build()
                workManager.enqueue(requestPlayers)

                val requestTeams = OneTimeWorkRequestBuilder<TeamsDatabaseWorker>()
                    .setInputData(workDataOf(TEAMS_KEY_FILENAME to TEAMS_DATA_FILENAME))
                    .build()
                workManager.enqueue(requestTeams)

                val playersTeams = OneTimeWorkRequestBuilder<PlayersTeamsDatabaseWorker>()
                    .setInputData(workDataOf(PLAYERS_TEAMS_KEY_FILENAME to PLAYERS_TEAMS_DATA_FILENAME))
                    .build()
                workManager.enqueue(playersTeams)
            }
        }
    }
}