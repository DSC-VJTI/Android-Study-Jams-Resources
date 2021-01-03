package com.example.myapplication.roomcode.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "body")
    var body: String
)