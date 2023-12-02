package com.example.strathnews.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.strathnews.Destination
import com.example.strathnews.Section
import com.example.strathnews.ui.theme.StrathNewsTheme


@Composable
fun TopNavBar(
    allScreens: List<Section>,
    onTabSelected: (Section) -> Unit,
    currentScreen: Section
){
    StrathNewsTheme {
        Surface(
            modifier = Modifier
                .height(TabHeight)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Row (
                modifier = Modifier
                    .selectableGroup()
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                allScreens.forEach{
                        screen ->
                    TopStrathTab(
                        text = screen.title,
                        onSelected = {  onTabSelected(screen)  },
                        selected = currentScreen == screen,
                    )
                }
            }
        }
    }
}

@Composable
fun TopStrathTab(
    text: String,
    onSelected: () -> Unit,
    selected: Boolean,
) {
    val color = MaterialTheme.colorScheme.onSurface
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = TabFadeInAnimationDelay
        )
    }

    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else color,
        animationSpec = animSpec
    )

    Column(
        modifier = Modifier
            .padding(8.dp)
            .animateContentSize()
            .height(TabHeight)
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
            )
            .clearAndSetSemantics { contentDescription = text },
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = text.capitalize(), color = Color.White,
            textDecoration = if (selected) TextDecoration.Underline else null)
    }
}


private val TabHeight = 48.dp

private const val TabFadeInAnimationDuration = 150
private const val TabFadeOutAnimationDuration = 100
private const val TabFadeInAnimationDelay = 100

