package pgm.poolp.ugcanvas.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import pgm.poolp.ugcanvas.data.TeamRepository
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject internal constructor(private val teamRepository: TeamRepository) : ViewModel()
{

    //val skillId: String = savedStateHandle.get<String>(SKILL_ID_SAVED_STATE_KEY)!!
    //val skill = skillRepository.getSkill(skillId).asLiveData()
    //val skillWithChampions = skillRepository.getSkillWithChampions(skillId).asLiveData()

    fun teamWithPlayers(teamId:String): Flow<TeamWithPlayers> {
        return teamRepository.getTeamWithPlayers(teamId)//.asLiveData()
    }
}
