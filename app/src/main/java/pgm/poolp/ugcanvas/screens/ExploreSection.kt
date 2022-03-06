package pgm.poolp.ugcanvas.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.asLiveData
import pgm.poolp.ugcanvas.theme.BottomSheetShape
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    title: String
) {

    val vm: TeamViewModel = hiltViewModel()
    val suggestedTeamWithPlayers by vm.teamWithPlayers("orcs").collectAsState(initial = null)

    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        LazyColumn(modifier = Modifier.padding(start = 24.dp, top = 20.dp, end = 24.dp)) {

            suggestedTeamWithPlayers?.let { teamWithPlayers ->

                items(teamWithPlayers.players) { player ->
                    Text(
                        text = player.name,
                        style = MaterialTheme.typography.h5,
                        /*
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {selectCharacter(character.id)})
                            //.padding(top = 12.dp, bottom = 12.dp)
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp,
                                bottom = 8.dp
                            )
                            .wrapContentWidth(Alignment.Start)
                    */
                    )
                }
            }
        }
    }
}