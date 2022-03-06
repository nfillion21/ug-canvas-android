package pgm.poolp.ugcanvas.data

import androidx.room.*

@Entity(primaryKeys = ["playerId", "teamId"])
data class PlayerTeamCrossRef(
    val playerId: String,
    val teamId: String,
)