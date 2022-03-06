package pgm.poolp.ugcanvas.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PlayersTeamsCrossRefDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(playersTeamsCrossRef: List<PlayerTeamCrossRef>)
}
