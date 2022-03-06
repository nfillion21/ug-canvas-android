package pgm.poolp.ugcanvas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey (autoGenerate = false) val teamId: String,
    val name: String
)
