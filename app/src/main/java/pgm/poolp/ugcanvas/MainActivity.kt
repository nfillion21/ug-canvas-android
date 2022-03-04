package pgm.poolp.ugcanvas

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import pgm.poolp.ugcanvas.ui.theme.UgcanvasTheme
import pgm.poolp.ugcanvas.ui.theme.screens.CanvasDrawExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        setContent {
            UgcanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(dpWidth)
                }
            }
        }
    }
}

@Composable
fun Greeting(screenWidth: Float) {
    //Text(text = "Hello $name!")
    CanvasDrawExample(screenWidth = screenWidth)
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