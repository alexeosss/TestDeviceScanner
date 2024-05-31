package com.publicttapp.testdevicescanner.data

import com.publicttapp.testdevicescanner.presentation.domain.AlertsDataClass


interface Repository {

    suspend fun getAllAlerts(): AlertsDataClass

    suspend fun addAllAlerts(data: AlertsDataClass)

    suspend fun updateAlerts(
        deviceInfo: Int,
        calibrationOfSensors: Int,
        appMonitoring: Int,
        antivirus: Int,
        deviceMemoryInfo: Int,
        fileManager: Int,
        batteryInfo: Int
    )

}