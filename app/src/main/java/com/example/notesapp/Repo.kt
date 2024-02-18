package com.example.notesapp


import androidx.lifecycle.LiveData
import com.example.notesapp.db.Dao
import com.example.notesapp.db.NoteClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repo(private var dao: Dao) {

    fun allNotesLD() : LiveData<List<NoteClass>> = dao.getAllNotesLD()

    fun allNotes() : List<NoteClass> = dao.getAllNotes()

    fun insert( note: NoteClass){
            dao.Insert(note)

    }
    fun delete( note: NoteClass) {
            dao.Delete(note)
    }
    fun update( note: NoteClass) {
            dao.Update(note)
    }
}