package pgm.poolp.ugcanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import pgm.poolp.ugcanvas.ui.theme.UgcanvasTheme
import pgm.poolp.ugcanvas.ui.theme.screens.CanvasDrawExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UgcanvasTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    //Text(text = "Hello $name!")
    CanvasDrawExample()
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