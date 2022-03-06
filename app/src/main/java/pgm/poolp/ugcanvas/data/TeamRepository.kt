package pgm.poolp.ugcanvas.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(private val teamDAO: TeamDAO) {

    fun getTeamWithPlayers(teamId: String) = teamDAO.getTeamWithPlayers(teamId)
}
