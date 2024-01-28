package com.example.notesapp


import com.example.notesapp.db.Dao
import com.example.notesapp.db.NoteClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repo(private var dao: Dao) {

    fun getAllNotes() = dao.getAllNotes()

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