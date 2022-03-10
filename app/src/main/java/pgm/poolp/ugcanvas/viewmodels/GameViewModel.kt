package pgm.poolp.ugcanvas.viewmodels

import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import pgm.poolp.ugcanvas.data.*
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject internal constructor(private val gameRepository: GameRepository, private val canvasRepository: UGCanvasRepository) : ViewModel()
{

    //val skillId: String = savedStateHandle.get<String>(SKILL_ID_SAVED_STATE_KEY)!!
    //val skill = skillRepository.getSkill(skillId).asLiveData()
    //val skillWithChampions = skillRepository.getSkillWithChampions(skillId).asLiveData()

    fun getGame(gameId:String): Flow<Game> {
        return gameRepository.getGame(gameId = gameId)//.asLiveData()
    }

    /*
    fun setGame(game:Game) {
        return gameRepository.
    }
    */

    fun dataBoard(): Flow<String?> {
        return canvasRepository.getDataBoard()
    }

    fun setDataBoard(teamWithPlayers: TeamWithPlayers) {
        //
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter: JsonAdapter<TeamWithPlayers> = moshi.adapter(TeamWithPlayers::class.java)
        val str = jsonAdapter.toJson(teamWithPlayers)
        canvasRepository.setDataBoard(data = str)
    }
}
