package com.example.notesapp

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notesapp.db.Dao
import com.example.notesapp.db.NoteClass
import com.example.notesapp.db.NoteDatabase
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NotesDBTest {

    private lateinit var noteDatabase: NoteDatabase
    private lateinit var dao: Dao

    @Before
    fun setup(){
        val  context = ApplicationProvider.getApplicationContext<Context>()
        noteDatabase = Room.inMemoryDatabaseBuilder(context,NoteDatabase::class.java).build()
        dao = noteDatabase.getNoteDao()
    }

    @After
    fun teardown(){
        noteDatabase.close()
    }

    @Test
    fun add_note_database() = runBlocking(Dispatchers.IO){
        val note = NoteClass(101,"Test Case1", "Test Case Description 1")
        dao.Insert(note)
        val notes = dao.getAllNotes()
        TestCase.assertTrue(notes!!.contains(note))
    }

    @Test
    fun delete_note_database() = runBlocking(Dispatchers.IO){
        val note = NoteClass(101,"Test Case1", "Test Case Description 1")
        dao.Delete(note)
        val notes = dao.getAllNotes()
        TestCase.assertTrue(!notes!!.contains(note))
    }
}