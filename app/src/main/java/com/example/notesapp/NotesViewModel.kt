package com.example.notesapp

import androidx.lifecycle.ViewModel
import com.example.notesapp.db.NoteClass

class NotesViewModel(
    private val repo: Repo
) : ViewModel(){
    fun getAllNotes() = repo.getAllNotes()

    fun insert( note: NoteClass){
        repo.insert(note)

    }
    fun delete( note: NoteClass) {
        repo.delete(note)
    }
    fun update( note: NoteClass) {
        repo.update(note)
    }
}