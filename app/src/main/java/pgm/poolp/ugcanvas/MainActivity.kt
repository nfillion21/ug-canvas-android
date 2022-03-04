package pgm.poolp.ugcanvas

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import pgm.poolp.ugcanvas.ui.theme.UGCanvasTheme
import pgm.poolp.ugcanvas.ui.theme.screens.CanvasDrawBoard
import pgm.poolp.ugcanvas.ui.theme.screens.ExploreSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density
        val dpHeight = displayMetrics.heightPixels / displayMetrics.density

        //WindowCompat.setDecorFitsSystemWindows(window, false)

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

    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)
    val scope = rememberCoroutineScope()

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        stickyFrontLayer = false,
        headerHeight = 64.dp,
        peekHeight = (screenHeight*0.5f).dp,
        appBar = {
            //HomeTabBar(openDrawer, tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = {
            CanvasDrawBoard(
                revealBackdropScaffold = {
                    scope.launch {
                        scaffoldState.conceal()
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