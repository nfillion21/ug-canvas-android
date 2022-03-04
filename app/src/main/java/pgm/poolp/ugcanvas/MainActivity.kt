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
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
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
                    ) { innerPaddingModifier ->
                        Greeting(dpWidth, innerPaddingModifier)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(screenWidth: Float, innerPaddingValues: PaddingValues) {
    //Text(text = "Hello $name!")
    CanvasDrawExample(
        screenWidth = screenWidth,
        modifier = Modifier.padding(innerPaddingValues)
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