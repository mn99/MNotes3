package com.mn9.mnotes3.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity
data class Note (
    var title: String,
    var body: String,
    var type: Int,
    var timestamp: Calendar
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}