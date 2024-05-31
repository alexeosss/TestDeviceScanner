package com.publicttapp.testdevicescanner.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.publicttapp.testdevicescanner.data.Repository
import com.publicttapp.testdevicescanner.presentation.domain.AlertsDataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<MainScreenUiState> =
        MutableStateFlow(MainScreenUiState())
    val uiState: StateFlow<MainScreenUiState> = _uiState


    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {

            val allAlerts = if (repository.getAllAlerts().isEmpty()) {
                AlertsDataClass()
            } else {
                repository.getAllAlerts()[0]
            }

            _uiState.update {
                it.copy(
                    data = allAlerts,
                    problems = allAlerts.deviceInfo
                            + allAlerts.deviceMemoryInfo
                            + allAlerts.batteryInfo
                            + allAlerts.appMonitoring
                            + allAlerts.antivirus
                            + allAlerts.calibrationOfSensors
                            + allAlerts.fileManager
                )
            }
        }
    }

    private fun addRandomData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (uiState.value.data == AlertsDataClass()) {
                repository.addAllAlerts(
                    AlertsDataClass(
                        deviceInfo = (0..5).random(),
                        calibrationOfSensors = (0..5).random(),
                        appMonitoring = (0..5).random(),
                        antivirus = (0..5).random(),
                        deviceMemoryInfo = (0..5).random(),
                        fileManager = (0..5).random(),
                        batteryInfo = (0..5).random()
                    )
                )
            } else {
                repository.updateAlerts(
                    deviceInfo = (0..5).random(),
                    calibrationOfSensors = (0..5).random(),
                    appMonitoring = (0..5).random(),
                    antivirus = (0..5).random(),
                    deviceMemoryInfo = (0..5).random(),
                    fileManager = (0..5).random(),
                    batteryInfo = (0..5).random()
                )
            }

            getData()
        }
    }

    fun updateData(funName: String) {
        viewModelScope.launch(Dispatchers.IO) {

            when (funName) {
                "deviceInfo" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                deviceInfo = 0
                            )
                        )
                    }
                }

                "calibrationOfSensors" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                calibrationOfSensors = 0
                            )
                        )
                    }
                }

                "appMonitoring" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                appMonitoring = 0
                            )
                        )
                    }
                }

                "antivirus" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                antivirus = 0
                            )
                        )
                    }
                }

                "deviceMemoryInfo" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                deviceMemoryInfo = 0
                            )
                        )
                    }
                }

                "fileManager" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                fileManager = 0
                            )
                        )
                    }
                }

                "batteryInfo" -> {
                    _uiState.update {
                        it.copy(
                            data = uiState.value.data.copy(
                                batteryInfo = 0
                            )
                        )
                    }
                }
            }

            repository.updateAlerts(
                deviceInfo = uiState.value.data.deviceInfo,
                calibrationOfSensors = uiState.value.data.calibrationOfSensors,
                appMonitoring = uiState.value.data.appMonitoring,
                antivirus = uiState.value.data.antivirus,
                deviceMemoryInfo = uiState.value.data.deviceMemoryInfo,
                fileManager = uiState.value.data.fileManager,
                batteryInfo = uiState.value.data.batteryInfo
            )

            getData()
        }
    }


    fun animation() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    isPlaying = true
                )
            }
            delay(1000)
            addRandomData()
            delay(1000)

            _uiState.update {
                it.copy(
                    isPlaying = false
                )
            }
        }
    }

}

data class MainScreenUiState(
    val data: AlertsDataClass = AlertsDataClass(),
    val problems: Int = 0,
    val isPlaying: Boolean = false
)