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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import pgm.poolp.ugcanvas.theme.BottomSheetShape
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    viewModel: TeamViewModel,
    launchGame: (TeamWithPlayers) -> Unit
) {

    val suggestedTeamWithPlayers by viewModel.dataBoard("humans").collectAsState(initial = null)

    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        LazyColumn(modifier = Modifier
            .padding(start = 24.dp, top = 20.dp, end = 24.dp)
        ) {

            suggestedTeamWithPlayers?.let { teamWithPlayers ->

                items(teamWithPlayers.players) { player ->
                    Text(
                        text = player.position,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.clickable { launchGame(teamWithPlayers) }
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