package com.mn9.mnotes2.db

import androidx.room.*
import com.mn9.mnotes2.models.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes ORDER BY timestamp desc")
    suspend fun getNotes(): List<Note>

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteWithId(id: Long) : Note?

    @Query("SELECT id FROM notes WHERE title = :title COLLATE NOCASE")
    suspend fun getNoteIdWithTitle(title: String) : Long?

    @Query("SELECT Id FROM notes WHERE title = :title")
    suspend fun getNoteIdWithTitleCaseSensitive(title: String) : Long?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(note: Note) : Long

    @Delete
    suspend fun deleteNote(note: Note)
}