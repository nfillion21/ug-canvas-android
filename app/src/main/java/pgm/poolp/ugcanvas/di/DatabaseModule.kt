package pgm.poolp.ugcanvas.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pgm.poolp.ugcanvas.data.PlayersDAO
import pgm.poolp.ugcanvas.data.PlayersTeamsCrossRefDAO
import pgm.poolp.ugcanvas.data.TeamDAO
import pgm.poolp.ugcanvas.data.UGCanvasRoomDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): UGCanvasRoomDatabase {
        return UGCanvasRoomDatabase.getInstance(context)
    }

    @Provides
    fun providePlayersDao(appDatabase: UGCanvasRoomDatabase): PlayersDAO {
        return appDatabase.playersDAO()
    }

    @Provides
    fun provideTeamsDao(appDatabase: UGCanvasRoomDatabase): TeamDAO {
        return appDatabase.teamsDAO()
    }

    @Provides
    fun providePlayersTeamsDao(appDatabase: UGCanvasRoomDatabase): PlayersTeamsCrossRefDAO {
        return appDatabase.playersTeamsCrossRefDAO()
    }
}
