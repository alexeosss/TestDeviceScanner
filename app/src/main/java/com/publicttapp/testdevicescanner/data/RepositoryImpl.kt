package com.publicttapp.testdevicescanner.data

import com.publicttapp.testdevicescanner.presentation.domain.AlertsDataClass

class RepositoryImpl(private val localDataSource: LocalDataSource) : Repository {
    override suspend fun getAllAlerts(): AlertsDataClass {
        return localDataSource.getAllAlerts().let {
            AlertsDataClass(
                it.id,
                it.deviceInfo,
                it.calibrationOfSensors,
                it.appMonitoring,
                it.antivirus,
                it.deviceMemoryInfo,
                it.fileManager,
                it.batteryInfo
            )
        }
    }

    override suspend fun addAllAlerts(data: AlertsDataClass) {
        return localDataSource.addAllAlerts(data.let {
            AlertsEntity(
                it.id,
                it.deviceInfo,
                it.calibrationOfSensors,
                it.appMonitoring,
                it.antivirus,
                it.deviceMemoryInfo,
                it.fileManager,
                it.batteryInfo
            )
        }
        )
    }

    override suspend fun updateAlerts(
        deviceInfo: Int,
        calibrationOfSensors: Int,
        appMonitoring: Int,
        antivirus: Int,
        deviceMemoryInfo: Int,
        fileManager: Int,
        batteryInfo: Int
    ) {
        return localDataSource.updateAlerts(
            deviceInfo,
            calibrationOfSensors,
            appMonitoring,
            antivirus,
            deviceMemoryInfo,
            fileManager,
            batteryInfo
        )
    }

}