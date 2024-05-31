package com.publicttapp.testdevicescanner.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalDataSource {


    @Query("SELECT * FROM alerts_table")
    fun getAllAlerts(): List<AlertsEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = AlertsEntity::class)
    fun addAllAlerts(data: AlertsEntity)

    @Query("UPDATE alerts_table SET device_info = :deviceInfo, calibration_of_sensors = :calibrationOfSensors, app_monitoring= :appMonitoring, antivirus= :antivirus, device_memory_info= :deviceMemoryInfo, file_manager= :fileManager, battery_info= :batteryInfo WHERE id = 1")
    fun updateAlerts(
        deviceInfo: Int,
        calibrationOfSensors: Int,
        appMonitoring: Int,
        antivirus: Int,
        deviceMemoryInfo: Int,
        fileManager: Int,
        batteryInfo: Int
    )
}