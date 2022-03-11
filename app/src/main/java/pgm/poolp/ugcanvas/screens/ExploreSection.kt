package pgm.poolp.ugcanvas.screens

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import pgm.poolp.ugcanvas.R
import pgm.poolp.ugcanvas.data.ExpandableCardModel
import pgm.poolp.ugcanvas.data.Player
import pgm.poolp.ugcanvas.data.TeamWithPlayers
import pgm.poolp.ugcanvas.theme.BottomSheetShape
import pgm.poolp.ugcanvas.theme.Green300
import pgm.poolp.ugcanvas.theme.cardCollapsedBackgroundColor
import pgm.poolp.ugcanvas.theme.cardExpandedBackgroundColor
import pgm.poolp.ugcanvas.utilities.*
import pgm.poolp.ugcanvas.viewmodels.CardsViewModel
import pgm.poolp.ugcanvas.viewmodels.TeamViewModel
import kotlin.math.roundToInt

@Composable
fun ExploreSection(
    modifier: Modifier = Modifier,
    viewModel: TeamViewModel,
    cardsViewModel: CardsViewModel,
    launchGame: (TeamWithPlayers) -> Unit,
    playerTo: (String, Utils.CardinalEnum, TeamWithPlayers) -> Unit
) {

    val suggestedTeamWithPlayers by viewModel.dataBoard("humans").collectAsState(initial = null)
    val suggestedDataboard by viewModel.dataBoard().collectAsState(initial = null)

    val expandedCardIds = cardsViewModel.expandedCardIdsList.collectAsState()

    Surface(modifier = modifier.fillMaxSize(), color = Color.White, shape = BottomSheetShape) {
        LazyColumn(modifier = Modifier
            .padding(start = 24.dp, top = 20.dp, end = 24.dp)
        ) {

            suggestedDataboard?.let { teamWithPlayersStr ->
                teamWithPlayersStr.let {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val jsonAdapter: JsonAdapter<TeamWithPlayers> = moshi.adapter(TeamWithPlayers::class.java)
                    val teamWithPlayers = jsonAdapter.fromJson(teamWithPlayersStr)

                    teamWithPlayers?.let {

                        /*
                        items(teamWithPlayers.players) { player ->
                            Text(
                                text = player.name + " " + player.position,
                                style = MaterialTheme.typography.h5,
                                modifier = Modifier.clickable { toTheNorth(player.playerId, teamWithPlayers) }
                            )
                        }
                        */

                        itemsIndexed(teamWithPlayers.players) { _, player ->
                            ExpandableCard(
                                player = player,
                                onCardArrowClick = { cardsViewModel.onCardArrowClicked(player.playerId) },
                                expanded = expandedCardIds.value.contains(player.playerId),
                                onDirectionClick = { p:Player, direction:Utils.CardinalEnum ->

                                    playerTo (p.playerId, direction, teamWithPlayers)
                                }
                            )
                        }
                    }
                }
            }

            suggestedTeamWithPlayers?.let { teamWithPlayers ->

                item {
                    Button(
                        onClick = { launchGame(teamWithPlayers) },
                        // Uses ButtonDefaults.ContentPadding by default
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            top = 12.dp,
                            end = 20.dp,
                            bottom = 12.dp
                        )
                    ) {
                        // Inner content including an icon and a text label
                        Icon(
                            Icons.Filled.Face,
                            contentDescription = "Favorite",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                        Text("Launch game")
                    }
                }
            }
        }
    }
}

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun ExpandableCard(
    player: Player,
    onCardArrowClick: () -> Unit,
    onDirectionClick: (Player, Utils.CardinalEnum) -> Unit,
    expanded: Boolean,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "transition")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "bgColorTransition") {
        if (expanded) cardCollapsedBackgroundColor else cardCollapsedBackgroundColor
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "paddingTransition") {
        if (expanded) 14.dp else 4.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "elevationTransition") {
        if (expanded) 24.dp else 4.dp
    }
    val cardRoundedCorners by transition.animateDp({
        tween(
            durationMillis = EXPAND_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    }, label = "cornersTransition") {
        if (expanded) 0.dp else 16.dp
    }
    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "rotationDegreeTransition") {
        if (expanded) 0f else 180f
    }

    Card(
        backgroundColor = cardBgColor,
        elevation = cardElevation,
        shape = RoundedCornerShape(cardRoundedCorners),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    ) {
        Column {
            Box {
                CardArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick
                )
                CardTitle(title = player.name)
            }
            ExpandableContent(
                visible = expanded,
                onDirectionClick = { cardinalDirection: Utils.CardinalEnum ->
                    onDirectionClick (player, cardinalDirection)
                }
            )
        }
    }
}

@Composable
fun CardArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_expand_less_24),
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
            )
        }
    )
}

@Composable
fun CardTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExpandableContent(
    visible: Boolean = true,
    onDirectionClick: (Utils.CardinalEnum) -> Unit
) {
    val enterFadeIn = remember {
        fadeIn(
            animationSpec = TweenSpec(
                durationMillis = FADE_IN_ANIMATION_DURATION,
                easing = FastOutLinearInEasing
            )
        )
    }
    val enterExpand = remember {
        expandVertically(animationSpec = tween(EXPAND_ANIMATION_DURATION))
    }
    val exitFadeOut = remember {
        fadeOut(
            animationSpec = TweenSpec(
                durationMillis = FADE_OUT_ANIMATION_DURATION,
                easing = LinearOutSlowInEasing
            )
        )
    }
    val exitCollapse = remember {
        shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION_DURATION))
    }
    AnimatedVisibility(
        visible = visible,
        enter = enterExpand + enterFadeIn,
        exit = exitCollapse + exitFadeOut
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.heightIn(100.dp))
            Text(
                text = "Expandable content here",
                textAlign = TextAlign.Center
            )
            Button(onClick = { onDirectionClick(Utils.CardinalEnum.NORTH_EAST)}) {

            }
        }
    }
}
