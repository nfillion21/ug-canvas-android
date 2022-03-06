package pgm.poolp.ugcanvas.screens

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pgm.poolp.ugcanvas.theme.BottomSheetShape
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    title: String
) {

    val vm: TeamViewModel = hiltViewModel()
    val suggestedTeamWithPlayers by vm.teamWithPlayers("humans").collectAsState(initial = null)

    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        Column(modifier = Modifier.padding(start = 24.dp, top = 20.dp, end = 24.dp)) {
            Text(
                text = title
            )

            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
            Text(
                text = title
            )
        }
    }
}