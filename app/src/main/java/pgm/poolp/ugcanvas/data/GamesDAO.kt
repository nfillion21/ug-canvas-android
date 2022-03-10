package pgm.poolp.ugcanvas.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDAO {

    /*
    // The flow always holds/caches latest version of data. Notifies its observers when the
    // data has changed.
    @Query("select * from champion order by name")
    fun getChampions(): Flow<List<Champion>>

    @Transaction
    @Query("select * from champion order by name")
    fun getChampionsWithSkills(): Flow<List<ChampionWithSkills>>

    @Query("delete from champion")
    suspend fun deleteAll()

    @Transaction
    @Query("select * from champion where championId = :championId")
    fun getChampionWithSkills(championId: String): Flow<ChampionWithSkills>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(champions: List<Player>)
    */
    @Query("select * from game where gameId = :gameId")
    fun getGame(gameId: String): Flow<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game)
}
