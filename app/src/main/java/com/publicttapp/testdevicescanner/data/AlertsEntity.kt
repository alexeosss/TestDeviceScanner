package com.publicttapp.testdevicescanner.data

import android.app.ApplicationErrorReport.BatteryInfo
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alerts_table")
data class AlertsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "device_info")
    var deviceInfo: Int = 0,

    @ColumnInfo(name = "calibration_of_sensors")
    var calibrationOfSensors: Int = 0,

    @ColumnInfo(name = "app_monitoring")
    var appMonitoring: Int = 0,

    @ColumnInfo(name = "antivirus")
    var antivirus: Int = 0,

    @ColumnInfo(name = "device_memory_info")
    var deviceMemoryInfo: Int = 0,

    @ColumnInfo(name = "file_manager")
    var fileManager: Int = 0,

    @ColumnInfo(name = "battery_info")
    var batteryInfo: Int = 0
)
