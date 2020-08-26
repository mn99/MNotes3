package com.mn9.mnotes2.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "notes")
data class Note (
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "value") var value: String,
    @ColumnInfo(name = "created") var created: String,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "timestamp") var timestamp: Long
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
