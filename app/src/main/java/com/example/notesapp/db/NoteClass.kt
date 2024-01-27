package com.example.notesapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "NotesTable")
data class NoteClass(
    @ColumnInfo(name = "id_2")
    val id : Int,
    @ColumnInfo(name = "notename_2")
    val notename : String,
    @ColumnInfo(name = "noteContent_2")
    val noteContent : String
)