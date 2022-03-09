package pgm.poolp.ugcanvas.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import pgm.poolp.ugcanvas.data.TeamRepository
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import pgm.poolp.ugcanvas.data.UGCanvasRepository
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject internal constructor(private val teamRepository: TeamRepository, private val canvasRepository: UGCanvasRepository) : ViewModel()
{

    //val skillId: String = savedStateHandle.get<String>(SKILL_ID_SAVED_STATE_KEY)!!
    //val skill = skillRepository.getSkill(skillId).asLiveData()
    //val skillWithChampions = skillRepository.getSkillWithChampions(skillId).asLiveData()

    fun teamWithPlayers(teamId:String): Flow<TeamWithPlayers> {
        return teamRepository.getTeamWithPlayers(teamId)//.asLiveData()
    }

    fun setDataBoard(data:String) {
        canvasRepository.setDataBoard(data = data)
    }
}
