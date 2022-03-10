package pgm.poolp.ugcanvas.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    @PrimaryKey (autoGenerate = false) val playerId: String,
    val name: String,
    var position: String
)
