package pgm.poolp.ugcanvas.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepository @Inject constructor(private val gamesDAO: GamesDAO) {

    fun getGame(gameId: String) = gamesDAO.getGame(gameId)
    suspend fun setGame(game: Game) = gamesDAO.insert(game)
}
