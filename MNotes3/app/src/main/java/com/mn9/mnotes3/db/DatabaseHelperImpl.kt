package com.mn9.mnotes3.db

import com.mn9.mnotes3.models.Note

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getAllNotes(): List<Note> = appDatabase.noteDao().getAll()

}