package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.notesapp.db.NoteClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(
    private val repo: Repo
) : ViewModel(){

    val allNotesLiveData = MutableLiveData<List<NoteClass>>()
    fun getAllNotesLD() = repo.allNotesLD()

    init {
        getAllNotes()
    }
    fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            allNotesLiveData.postValue(repo.allNotes())
        }
    }

    fun Insert( note: NoteClass){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(note)
        }
    }
    fun Delete( note: NoteClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.delete(note)
        }
    }
    fun Update( note: NoteClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.update(note)
        }
    }

}