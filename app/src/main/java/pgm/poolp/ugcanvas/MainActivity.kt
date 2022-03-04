package pgm.poolp.ugcanvas

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.launch
import pgm.poolp.ugcanvas.ui.theme.UGCanvasTheme
import pgm.poolp.ugcanvas.ui.theme.screens.CanvasDrawExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets {
                UGCanvasTheme {
                    Scaffold(
                        backgroundColor = MaterialTheme.colors.primarySurface,
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
                        BoardScreen(dpWidth, Modifier.padding(innerPaddingModifier))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BoardScreen(screenWidth: Float, modifier:Modifier) {
    //Text(text = "Hello $name!")

    BackdropScaffold(
        modifier = modifier,
        /*
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerScrimColor = Color.Unspecified,
        */
        appBar = {
            //HomeTabBar(openDrawer, tabSelected, onTabSelected = { tabSelected = it })
        },
        backLayerContent = {
            CanvasDrawExample(
                screenWidth = screenWidth,
                modifier = modifier
            )
        },
        frontLayerContent = {
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