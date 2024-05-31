package com.publicttapp.testdevicescanner.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.publicttapp.testdevicescanner.R

@Composable
fun CircleScanCard(problems: Int, onClick: () -> Unit) {

    Button(
        onClick = {
            onClick.invoke()},
        modifier = Modifier.size(224.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
        shape = CircleShape,
        border = BorderStroke(7.dp, MaterialTheme.colorScheme.onPrimary)
    ) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 20.dp, bottom = 45.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.at_logo),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )

            Text(
                text = stringResource(id = R.string.scan),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_problems),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error
                )
                Text(
                    text = problems.plus(stringResource(id = R.string.problems)),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.error
                )
            }


        }


    }


}

private operator fun Int.plus(stringResource: String): String {
    return "$this $stringResource"
}
