package com.publicttapp.testdevicescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.publicttapp.testdevicescanner.presentation.screens.main.MainScreen
import com.publicttapp.testdevicescanner.presentation.ui.theme.TestDeviceScannerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestDeviceScannerTheme {
                MainScreen()

            }
        }
    }
}
