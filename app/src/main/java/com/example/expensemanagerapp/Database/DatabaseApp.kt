package com.example.expensemanagerapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensemanagerapp.DAO.IncomeDao
import com.example.expensemanagerapp.Model.IncomeEntity

@Database(entities = [IncomeEntity::class], version = 1)
abstract class database : RoomDatabase() {
    abstract fun getIDao(): IncomeDao

    companion object {
        @Volatile
        private var instance: database? = null

        @Synchronized
        fun getInstance(context: Context): database {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context.applicationContext,
                        database::class.java, "my-database").build()
                }
            }
            return instance!!
        }
    }
}