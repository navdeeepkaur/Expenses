package com.example.sample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Expenses::class), version = 1, exportSchema = false)
abstract class ExpensesDatabase:RoomDatabase() {

    abstract fun getExpensesDao():ExpensesDao


        companion object {
            // Singleton prevents multiple instances of database opening at the
            // same time.
            @Volatile
            private var INSTANCE: ExpensesDatabase? = null

            fun getDatabase(context: Context): ExpensesDatabase {
                // if the INSTANCE is not null, then return it,
                // if it is, then create the database
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExpensesDatabase::class.java,
                        "expenses_database"
                    ).build()
                    INSTANCE = instance
                    // return instance
                    instance
                }
            }
        }
    }
