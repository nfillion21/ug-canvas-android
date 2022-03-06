package pgm.poolp.ugcanvas.screens

import pgm.poolp.ugcanvas.R
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.statusBarsPadding
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel
import kotlin.math.roundToInt


//@Preview(showBackground = true)
@Composable
fun CanvasDrawBoard(
    screenWidth:Float,
    modifier:Modifier,
    revealBackdropScaffold: () -> Unit,
) {

    val halfSquareWidth = 0.03125f // 1/32
    val squareWidth = 0.0625f // 1/16
    val screenHeight = screenWidth*1.8
    val ic_image = ImageBitmap.imageResource(id = R.drawable.outline_sports_martial_arts_black_48)

    val vm: TeamViewModel = hiltViewModel()
    val suggestedTeamWithPlayers by vm.teamWithPlayers("orcs").collectAsState(initial = null)

    Column(modifier = modifier
        .fillMaxSize()
        .statusBarsPadding()
        .clickable(onClick = revealBackdropScaffold)
        //.navigationBarsPadding()
    ) {

        Canvas(modifier = Modifier
            .clickable(onClick = revealBackdropScaffold)
            .horizontalScroll(rememberScrollState())
            .verticalScroll(rememberScrollState())
            .width(screenWidth.dp)
            .height(screenHeight.dp)
        ) {

            /*
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
            */

            suggestedTeamWithPlayers?.let { teamWithPlayers ->
                drawImage(
                    image = ic_image,
                    dstOffset = IntOffset((size.width * squareWidth * 4.5).roundToInt(), (size.width * squareWidth * 11.5).roundToInt()),
                    dstSize = IntSize((size.width * squareWidth ).roundToInt(), (size.width * squareWidth).roundToInt()),
                    style = Fill
                )
            }

            /*
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
            */
        }
    }
}