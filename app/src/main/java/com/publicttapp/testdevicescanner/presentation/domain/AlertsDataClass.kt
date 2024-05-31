package com.publicttapp.testdevicescanner.presentation.domain

data class AlertsDataClass(
    var id: Int = 0,
    var deviceInfo: Int = 0,
    var calibrationOfSensors: Int = 0,
    var appMonitoring: Int = 0,
    var antivirus: Int = 0,
    var deviceMemoryInfo: Int = 0,
    var fileManager: Int = 0,
    var batteryInfo: Int = 0
)
