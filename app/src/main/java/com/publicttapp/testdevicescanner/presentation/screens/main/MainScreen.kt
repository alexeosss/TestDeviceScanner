package com.publicttapp.testdevicescanner.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.publicttapp.testdevicescanner.R
import com.publicttapp.testdevicescanner.presentation.components.CircleScanCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleDashboardCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleScreenCard


@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getData()
    })

    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {

        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.dashboard_animation)
        )


        Box(
            modifier = Modifier
                .size(350.dp)
                .align(Alignment.TopCenter), contentAlignment = Alignment.Center
        ) {
            LottieAnimation(
                composition = composition,
                iterations = if (!uiState.isPlaying) 1 else LottieConstants.IterateForever,
                modifier = Modifier.size(350.dp)
            )
            CircleScanCard(problems = uiState.problems) {
                viewModel.animation()
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

        var startHeight by remember { mutableStateOf(550.dp) }

        Column(
            modifier = Modifier
                .padding(top = startHeight)
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
                )
                .background(MaterialTheme.colorScheme.onSecondary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDrag = { _, dragAmount ->
                                startHeight = when {
                                    startHeight + dragAmount.y.toDp() in 100.dp..550.dp -> startHeight + dragAmount.y.toDp()
                                    startHeight + dragAmount.y.toDp() < 100.dp -> 100.dp
                                    else -> 550.dp
                                }

                            }
                        )
                    }, horizontalAlignment = Alignment.CenterHorizontally
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
            }


            LazyColumn(
                Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_info_square),
                        primaryText = stringResource(id = R.string.device_info),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.deviceInfo
                    ) {
                        viewModel.updateData("deviceInfo")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_smartphone_rotate_angle),
                        primaryText = stringResource(id = R.string.calibration_of_sensors),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.calibrationOfSensors
                    ) {
                        viewModel.updateData("calibrationOfSensors")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_object_scan),
                        primaryText = stringResource(id = R.string.app_monitoring),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.appMonitoring
                    ) {
                        viewModel.updateData("appMonitoring")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_virus_filled),
                        primaryText = stringResource(id = R.string.antivirus),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.antivirus
                    ) {
                        viewModel.updateData("antivirus")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_library),
                        primaryText = stringResource(id = R.string.device_memory_info),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.deviceMemoryInfo
                    ) {
                        viewModel.updateData("deviceMemoryInfo")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_file_smile),
                        primaryText = stringResource(id = R.string.file_mananger),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.fileManager
                    ) {
                        viewModel.updateData("fileManager")
                    }
                }
                item {
                    RectangleDashboardCard(
                        iconImage = painterResource(id = R.drawable.ic_battery_full),
                        primaryText = stringResource(id = R.string.battery_info),
                        secondaryText = stringResource(id = R.string.show_you_all_info),
                        uiState.data.batteryInfo
                    ) {
                        viewModel.updateData("batteryInfo")
                    }
                }
            }
        }
    }
}