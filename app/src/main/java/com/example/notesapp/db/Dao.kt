package com.example.notesapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.db.NoteClass

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insert(note: NoteClass)

    @Update
    fun Update(note: NoteClass)

    @Delete
    fun Delete(note: NoteClass)

    @Query("Select * from NotesTable")
    fun getAllNotesLD(): LiveData<List<NoteClass>>

    @Query("Select * from NotesTable")
    fun getAllNotes(): List<NoteClass>
}