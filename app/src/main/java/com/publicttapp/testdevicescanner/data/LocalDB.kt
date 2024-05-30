package com.publicttapp.testdevicescanner.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlertsEntity::class], version = 1)
internal abstract class LocalDB: RoomDatabase() {
    abstract fun dao(): LocalDataSource
}