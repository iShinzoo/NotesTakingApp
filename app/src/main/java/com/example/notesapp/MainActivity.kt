package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.db.NoteDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var repo: Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        notesViewModel.getAllNotes().observe(this){
            notesAdapter = NotesAdapter(it)
            rv.adapter = notesAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun init(){
        noteDatabase = NoteDatabase(this)
        repo = Repo(noteDatabase.getNoteDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this,notesViewModelFactory).get(NotesViewModel::class.java)
        rv = findViewById(R.id.rv)
    }
}