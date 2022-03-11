package pgm.poolp.ugcanvas.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardsViewModel @Inject internal constructor() : ViewModel() {

    //private val _cards = MutableStateFlow(listOf<ExpandableCardModel>())
    //val cards: StateFlow<List<ExpandableCardModel>> get() = _cards

    private val _expandedCardIdsList = MutableStateFlow(listOf<String>())
    val expandedCardIdsList: StateFlow<List<String>> get() = _expandedCardIdsList

    /*
    init {
        getFakeData()
    }
    */

    /*
    private fun getFakeData() {
        viewModelScope.launch(Dispatchers.Default) {
            val testList = arrayListOf<ExpandableCardModel>()
            repeat(20) { testList += ExpandableCardModel(id = it, title = "Card $it") }
            _cards.emit(testList)
        }
    }
    */

    fun onCardArrowClicked(cardId: String) {
        _expandedCardIdsList.value = _expandedCardIdsList.value.toMutableList().also { list ->
            if (list.contains(cardId)) list.remove(cardId) else list.add(cardId)
        }
    }
}
