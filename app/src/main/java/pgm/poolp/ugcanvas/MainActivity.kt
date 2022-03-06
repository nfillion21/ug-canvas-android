package pgm.poolp.ugcanvas

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pgm.poolp.ugcanvas.theme.UGCanvasTheme
import pgm.poolp.ugcanvas.screens.CanvasDrawBoard
import pgm.poolp.ugcanvas.screens.ExploreSection
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val dpHeight = displayMetrics.heightPixels / displayMetrics.density

        /*
        val icon: Bitmap = BitmapFactory.decodeResource(
            resources,
            R.drawable.ic_launcher_background
        )
        */


        setContent {
            //ProvideWindowInsets {
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
                    BoardScreen(dpWidth, dpHeight, Modifier.padding(innerPaddingModifier))
                }
            }
            //}
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoardScreen(
    screenWidth: Float,
    screenHeight:Float,
    modifier:Modifier) {
    //Text(text = "Hello $name!")

    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    val scope = rememberCoroutineScope()

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        stickyFrontLayer = false,
        headerHeight = 64.dp,
        peekHeight = (screenHeight * 0.5f).dp,
        appBar = {
            //HomeTabBar(openDrawer, tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = {
            CanvasDrawBoard(
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
                screenWidth = screenWidth,
                modifier = modifier
            )
        },
        frontLayerContent = {
            ExploreSection(
                title = "Explore pictures of this character"
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