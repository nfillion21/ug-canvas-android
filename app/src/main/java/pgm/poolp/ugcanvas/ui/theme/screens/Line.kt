package pgm.poolp.ugcanvas.ui.theme.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.unit.dp


//@Preview(showBackground = true)
@Composable
fun CanvasDrawExample(screenWidth:Float) {

    val color = MaterialTheme.colors.secondary
    val halfSquareWidth = 0.03125f // 1/32
    val squareWidth = 0.0625f // 1/16
    val screenHeight = screenWidth*1.8

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color)
    ) {

    Canvas(modifier = Modifier
        .horizontalScroll(rememberScrollState())
        .verticalScroll(rememberScrollState())
        //.padding(16.dp)
        //.background(Color.White)
        .width(screenWidth.dp)
        .height(screenHeight.dp)
            //.width(900.dp)
            //.height(900.dp)
            ///.fillMaxSize()
            //.size(size = 800.dp)
        ) {
            /*
            drawRect(
                color = color,
                topLeft = Offset(0f, 0f),
                size = Size(size.width, size.height)
                //style = Stroke(width = size.width * 0.075f)
            )
            */

            // first horizontal line
            drawLine(
                Color.White,
                start = Offset(size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
                end = Offset(
                    size.width - size.width * squareWidth * 0.5f,
                    size.width * halfSquareWidth
                ),
                strokeWidth = size.width * 0.010f,
            )

            // second horizontal line
            drawLine(
                Color.White,
                start = Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 1.5f),
                end = Offset(
                    size.width - size.width * squareWidth * 0.5f,
                    size.width * squareWidth * 1.5f
                ),
                strokeWidth = size.width * 0.010f,
            )

            // first vertical line
            drawLine(
                Color.White,
                start = Offset(size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
                end = Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 26.5f),
                strokeWidth = size.width * 0.010f,
            )

            // second vertical line
            drawLine(
                Color.White,
                start = Offset(
                    size.width - size.width * halfSquareWidth,
                    size.width * halfSquareWidth
                ),
                end = Offset(
                    size.width - size.width * halfSquareWidth,
                    size.width * squareWidth * 26.5f
                ),
                strokeWidth = size.width * 0.010f,
            )

            // third vertical line
            drawLine(
                Color.White,
                start = Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 1.5f),
                end = Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 25.5f),
                strokeWidth = size.width * 0.010f,
            )

            // fourth vertical line
            drawLine(
                Color.White,
                start = Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 1.5f),
                end = Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 25.5f),
                strokeWidth = size.width * 0.010f,
            )

            // bottom horizontal line
            drawLine(
                Color.White,
                start = Offset(size.width * halfSquareWidth, size.width * squareWidth * 26.5f),
                end = Offset(
                    size.width - size.width * halfSquareWidth,
                    size.width * squareWidth * 26.5f
                ),
                strokeWidth = size.width * 0.010f,
            )

            // line above
            drawLine(
                Color.White,
                start = Offset(size.width * halfSquareWidth, size.width * squareWidth * 25.5f),
                end = Offset(
                    size.width - size.width * halfSquareWidth,
                    size.width * squareWidth * 25.5f
                ),
                strokeWidth = size.width * 0.010f,
            )

            // center line
            drawLine(
                Color.White,
                start = Offset(size.width * halfSquareWidth, size.width * squareWidth * 13.5f),
                end = Offset(
                    size.width - size.width * halfSquareWidth,
                    size.width * squareWidth * 13.5f
                ),
                strokeWidth = size.width * 0.010f,
            )

            drawPoints(
                points = listOf(
                    // 1st line
                    Offset(size.width * squareWidth * 0.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 1.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 2.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 3.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 4.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 5.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 6.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 7.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 8.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 9.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 10.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 11.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 12.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 13.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 14.5f, size.width * halfSquareWidth),
                    Offset(size.width * squareWidth * 15.5f, size.width * halfSquareWidth),

                    // 2nd line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 1.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 1.5f),

                    // 3rd line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 2.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 2.5f),

                    // 4th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 3.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 3.5f),

                    // 5th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 4.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 4.5f),

                    // 6th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 5.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 5.5f),

                    // 7th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 6.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 6.5f),

                    // 8th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 7.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 7.5f),

                    // 9th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 8.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 8.5f),


                    // 10th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 9.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 9.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 10.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 10.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 11.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 11.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 12.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 12.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 13.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 13.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 14.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 14.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 15.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 15.5f),


                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 16.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 16.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 17.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 17.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 18.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 18.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 19.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 19.5f),
                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 20.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 20.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 21.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 21.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 22.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 22.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 23.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 23.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 24.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 24.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 25.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 25.5f),

                    // 11th line
                    Offset(size.width * squareWidth * 0.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 1.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 2.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 3.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 4.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 5.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 6.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 7.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 8.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 9.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 10.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 11.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 12.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 13.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 14.5f, size.width * squareWidth * 26.5f),
                    Offset(size.width * squareWidth * 15.5f, size.width * squareWidth * 26.5f),
                ),
                pointMode = PointMode.Points,
                color = Color.DarkGray,
                strokeWidth = size.width * 0.005f,
            )
        }
    }
}