package com.example.notesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.db.NoteClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repo: Repo
) : ViewModel(){
    fun getAllNotes() = repo.getAllNotes()

    fun insert( note: NoteClass){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(note)
        }
    }
    fun delete( note: NoteClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(note)
        }
    }
    fun update( note: NoteClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.update(note)
        }
    }

}