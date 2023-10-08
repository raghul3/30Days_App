package com.raghul.a30days

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raghul.a30days.Data.progress


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun progresslist(
    progress: List<progress>,
    modifier: Modifier=Modifier,
    contentPadding: PaddingValues= PaddingValues(0.dp)
){
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn(contentPadding = contentPadding) {
            itemsIndexed(progress) { index, process ->
                progressListItem(
                    process = process,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        // Animate each list item to slide in vertically
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = Spring.StiffnessVeryLow,
                                    dampingRatio = Spring.DampingRatioLowBouncy
                                ),
                                initialOffsetY = { it * (index + 1) }
                            )
                        )
                )
            }
        }
    }
}


@Composable
fun progressListItem(
    process: progress,
    modifier: Modifier=Modifier
){

    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        modifier = modifier
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ){
            Text(text = stringResource(process.days),
                style = MaterialTheme.typography.displayMedium,
                fontSize = 25.sp
                )
            Text(text = stringResource(id = process.nameres),
                style = MaterialTheme.typography.displayMedium,
                fontSize = 28.sp
                )
            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.CenterHorizontally)
            ){
                Image(painter = painterResource(id = process.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier=Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
                        .clip(RoundedCornerShape(18.dp))

                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = stringResource(id = process.descriptionres),
                style=MaterialTheme.typography.displaySmall,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
                )

        }
    }
}