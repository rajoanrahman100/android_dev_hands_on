package com.example.myapplication.roomDB_crud_project.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    //Returns an instance of Student Dao interface
    abstract fun studentDao():StudentDao

    companion object{
        @Volatile
        private var INSTANCE:StudentDatabase? = null

        fun getInstance(context:Context):StudentDatabase{
            synchronized(this){
                var instance= INSTANCE
                if(instance==null){
                    instance=Room.databaseBuilder(
                        context.applicationContext,StudentDatabase::class.java,"student_data_database"
                    ).build()
                }
                return instance
            }

        }
    }
}