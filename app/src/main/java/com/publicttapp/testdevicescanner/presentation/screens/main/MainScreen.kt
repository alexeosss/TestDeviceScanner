package com.publicttapp.testdevicescanner.presentation.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.publicttapp.testdevicescanner.R
import com.publicttapp.testdevicescanner.presentation.components.CircleScanCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleDashboardCard
import com.publicttapp.testdevicescanner.presentation.components.RectangleScreenCard

@Composable
fun MainScreen() {

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        CircleScanCard(problems = 12){

        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
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

        RectangleDashboardCard()


    }

}