package pgm.poolp.ugcanvas.data

import androidx.room.*

data class TeamWithPlayers(
    @Embedded val team: Team,
    @Relation(
        parentColumn = "teamId",
        entityColumn = "playerId",
        associateBy = Junction(PlayerTeamCrossRef::class)
    )
    val players: List<Player>
)
