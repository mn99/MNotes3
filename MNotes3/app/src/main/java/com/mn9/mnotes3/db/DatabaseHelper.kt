package com.mn9.mnotes3.db

import com.mn9.mnotes3.models.Note

interface DatabaseHelper {

    suspend fun getAllNotes(): List<Note>

}