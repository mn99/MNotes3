package com.mn9.mnotes3.db

import androidx.room.*
import com.mn9.mnotes3.models.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note ORDER BY timestamp DESC")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)



}