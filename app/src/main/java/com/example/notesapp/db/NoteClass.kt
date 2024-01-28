package com.example.notesapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
data class NoteClass(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val notename : String,
    val noteContent : String
)