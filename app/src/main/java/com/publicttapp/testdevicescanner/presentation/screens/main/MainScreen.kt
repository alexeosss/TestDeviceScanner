package com.publicttapp.testdevicescanner.presentation.screens.main

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.publicttapp.testdevicescanner.R
import com.publicttapp.testdevicescanner.presentation.components.CircleScanCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleDashboardCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleScreenCard
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.dashboard_animation)
        )

        var isPlaying by remember {
            mutableStateOf(false)
        }

        Box(
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.TopCenter), contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = composition,
                iterations = if (!isPlaying) 1 else LottieConstants.IterateForever,
                modifier = Modifier.size(350.dp)
            )
            CircleScanCard(problems = 12) {
                println("scan")

                GlobalScope.launch {
                    isPlaying = true
                    delay(2000)
                    isPlaying = false
                }
            }

        }

        Row(
            Modifier
                .padding(top = 64.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RectangleScreenCard(
                iconImage = painterResource(id = R.drawable.ic_smartphone),
                primaryText = stringResource(id = R.string.device_scan),
                secondaryText = stringResource(id = R.string.show_you_all_info),
                buttonText = stringResource(id = R.string.scan)
            )

            RectangleScreenCard(
                iconImage = painterResource(id = R.drawable.ic_virus),
                primaryText = stringResource(id = R.string.check_for_viruses),
                secondaryText = stringResource(id = R.string.show_you_all_info),
                buttonText = stringResource(id = R.string.check)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 550.dp)
                .fillMaxWidth()
                .height(820.dp)
                .align(Alignment.BottomCenter)
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ).background(MaterialTheme.colorScheme.onSecondary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp)
                    .size(53.dp, 6.dp)
                    .clip(RoundedCornerShape(26.dp))
                    .background(Color(0xFFDFE1E5))
            )

            Text(
                text = stringResource(id = R.string.dashboard),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            LazyColumn(
                Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_object_scan),
                        primaryText = stringResource(id = R.string.device_info),
                        secondaryText = stringResource(id = R.string.show_you_all_info)
                    )
                }
                item {

                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_object_scan),
                        primaryText = stringResource(id = R.string.device_info),
                        secondaryText = stringResource(id = R.string.show_you_all_info)
                    )
                }
            }

        }


    }

}

@Composable
fun getTopPaddingVal(
    isOpenFullWindow: Boolean,
    topPaddingVal: Dp
): Dp {
    return when {
        isOpenFullWindow -> 300.dp
        else -> topPaddingVal
    }
}