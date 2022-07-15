package com.coucouapp.database

import androidx.room.*
import com.coucouapp.database.entity.*

@Database(
    entities = arrayOf(Login::class),
    version = 1,
    exportSchema = false)
abstract class CoucouDb : RoomDatabase() {

}