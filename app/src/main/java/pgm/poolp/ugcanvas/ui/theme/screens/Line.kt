package pgm.poolp.ugcanvas.ui.theme.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CanvasDrawExample() {

    val color = MaterialTheme.colors.secondary
    val halfSquareWidth = 0.03125f // 1/32
    val squareWidth = 0.0625f // 1/16

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(
            color = color,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height)
            //style = Stroke(width = size.width * 0.075f)
        )

        // first line corner top left, from top to bottom
        /*
        drawLine(
            Color.Yellow,
            start = Offset(size.width * outsideSpace, size.width * outsideSpace),
            end = Offset(size.width * outsideSpace, size.height - size.width * outsideSpace),
            strokeWidth = size.width * 0.010f,
        )

        drawLine(
            Color.Yellow,
            start = Offset(size.width - size.width * outsideSpace, size.width * outsideSpace),
            end = Offset(size.width - size.width * outsideSpace, size.height - size.width * outsideSpace),
            strokeWidth = size.width * 0.010f,
        )
        */

        drawLine(
            Color.White,
            start = Offset(size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
            end = Offset(size.width - size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
            strokeWidth = size.width * 0.010f,
        )

        drawPoints(
            points = listOf(
                // 1st line
                Offset(size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 1.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 2.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 3.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 4.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 5.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 6.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 7.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 8.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 9.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 10.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 11.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 12.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 13.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 14.5f , size.width * halfSquareWidth),
                Offset(size.width * squareWidth * 15.5f , size.width * halfSquareWidth),

                // 2nd line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 1.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 1.5f),

                // 3rd line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 2.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 2.5f),

                // 4th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 3.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 3.5f),

                // 5th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 4.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 4.5f),

                // 6th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 5.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 5.5f),

                // 7th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 6.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 6.5f),

                // 8th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 7.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 7.5f),

                // 9th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 8.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 8.5f),


                // 9th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 9.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 9.5f),

                // 10th line
                Offset(size.width * squareWidth * 0.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 1.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 2.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 3.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 4.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 5.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 6.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 7.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 8.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 9.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 10.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 11.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 12.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 13.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 14.5f , size.width * squareWidth * 10.5f),
                Offset(size.width * squareWidth * 15.5f , size.width * squareWidth * 10.5f),

            ),
            pointMode = PointMode.Points,
            color = Color.Black,
            strokeWidth = size.width * 0.005f,
        )

        /*
        drawArc(
            Color.Black,
            0f,
            60f,
            useCenter = true,
            size = Size(300f, 300f),
            topLeft = Offset(60f, 60f)
        )
         */
    }
}