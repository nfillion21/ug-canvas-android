package pgm.poolp.ugcanvas.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import pgm.poolp.ugcanvas.data.Player
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import pgm.poolp.ugcanvas.theme.BottomSheetShape
import pgm.poolp.ugcanvas.utilities.Utils
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel
import kotlin.math.roundToInt

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    viewModel: TeamViewModel,
    launchGame: (TeamWithPlayers) -> Unit,
    toTheNorth: (String, TeamWithPlayers) -> Unit
) {

    val suggestedTeamWithPlayers by viewModel.dataBoard("humans").collectAsState(initial = null)
    val suggestedDataboard by viewModel.dataBoard().collectAsState(initial = null)

    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        LazyColumn(modifier = Modifier
            .padding(start = 24.dp, top = 20.dp, end = 24.dp)
        ) {

            suggestedDataboard?.let { teamWithPlayersStr ->
                teamWithPlayersStr.let {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val jsonAdapter: JsonAdapter<TeamWithPlayers> = moshi.adapter(TeamWithPlayers::class.java)
                    val teamWithPlayers = jsonAdapter.fromJson(teamWithPlayersStr)

                    teamWithPlayers?.let {

                        items(teamWithPlayers.players) { player ->
                            Text(
                                text = player.name + " " + player.position,
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.clickable { toTheNorth(player.playerId, teamWithPlayers) }
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

            suggestedTeamWithPlayers?.let { teamWithPlayers ->

                item {
                    Button(
                        onClick = { launchGame(teamWithPlayers) },
                        // Uses ButtonDefaults.ContentPadding by default
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            top = 12.dp,
                            end = 20.dp,
                            bottom = 12.dp
                        )
                    ) {
                        // Inner content including an icon and a text label
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("Launch game")
                    }
                }
            }
        }
    }
}