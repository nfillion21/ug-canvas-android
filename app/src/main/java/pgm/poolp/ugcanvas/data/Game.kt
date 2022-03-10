package pgm.poolp.ugcanvas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey (autoGenerate = false) val gameId: String,
    val databoard: String
)
