package pgm.poolp.ugcanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import pgm.poolp.ugcanvas.data.Player
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import pgm.poolp.ugcanvas.screens.CanvasDrawBoard
import pgm.poolp.ugcanvas.screens.ExploreSection
import pgm.poolp.ugcanvas.theme.UGCanvasTheme
import pgm.poolp.ugcanvas.utilities.Utils
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UGCanvasTheme {
                Scaffold(
                    drawerContent = {
                        /*
                        CraneDrawer(
                            modifier = modifier,
                            selectCharacter = {
                                mutableCharacterId = it
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                        */
                    }

                ) { innerPaddingModifier ->
                    BoardScreen(Modifier.padding(innerPaddingModifier))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoardScreen(
    modifier:Modifier) {
    //Text(text = "Hello $name!")

    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    val scope = rememberCoroutineScope()

    val vm: TeamViewModel = hiltViewModel()

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        stickyFrontLayer = false,
        headerHeight = 64.dp,
        peekHeight = (LocalConfiguration.current.screenHeightDp * 0.5f).dp,
        appBar = {
            //HomeTabBar(openDrawer, tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = {
            CanvasDrawBoard(
                viewModel = vm,
                revealBackdropScaffold = {
                    if (scaffoldState.isConcealed) {
                        scope.launch {
                            scaffoldState.reveal()
                        }
                    } else if (scaffoldState.isRevealed) {
                        scope.launch {
                            scaffoldState.conceal()
                        }
                    }
                },
                modifier = modifier
            )
        },
        frontLayerContent = {
            ExploreSection(
                //title = "Explore pictures of this character"
                viewModel = vm,
                cardsViewModel = hiltViewModel(),
                launchGame = {
                    vm.setDataBoard(teamWithPlayers = it)
                },
                toTheNorth = { playerId: String, teamWithPlayers: TeamWithPlayers ->
                    val players = teamWithPlayers.players
                    val player = players.find { it.playerId == playerId }
                    if (player != null)
                    {
                        player.position = Utils.getOfficialPosFromCardinalPoint(player.position, Utils.CardinalEnum.NORTH)
                        val newPlayers = players.toMutableList()
                        newPlayers[newPlayers.indexOf(player)] = player
                        teamWithPlayers.players = newPlayers.toList()
                        vm.setDataBoard(teamWithPlayers = teamWithPlayers)
                    }
                }
            )
        }
    )
}

/*
@Composable

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UgcanvasTheme {
        Greeting("Android")
    }
}
*/