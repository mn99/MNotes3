package com.mn9.mnotes3.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.mn9.mnotes3.models.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao

}