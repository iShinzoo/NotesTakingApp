package com.example.notesapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.db.NoteClass
import com.example.notesapp.db.NoteDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() , NotesAdapter.ClickListner{
    private lateinit var repo: Repo
    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesViewModelFactory: NotesViewModelFactory
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var rv : RecyclerView
    private lateinit var fab : FloatingActionButton
    private lateinit var dialog: Dialog
    private lateinit var edtNotetitle : EditText
    private lateinit var edtNoteContent : EditText
    private lateinit var btnSaveNote : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        fab.setOnClickListener(){
            openDialog(comingFromFAB = true)
        }

        notesViewModel.getAllNotesLD().observe(this){
            notesAdapter = NotesAdapter(it,this)
            rv.adapter = notesAdapter
            rv.layoutManager = LinearLayoutManager(this)
        }

        notesViewModel.allNotesLiveData.observe(this){
            Log.i("DB_LIST",it.toString())
        }
    }

    private fun openDialog(comingFromFAB : Boolean){
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.layout_dailog)

        edtNotetitle = dialog.findViewById(R.id.edtTitle)
        edtNoteContent = dialog.findViewById(R.id.edtContent)
        btnSaveNote = dialog.findViewById(R.id.btnSaveNote)

        btnSaveNote.setOnClickListener(){
            val note = NoteClass(
                notename = edtNotetitle.text.toString(),
                noteContent = edtNoteContent.text.toString()
            )
            if(comingFromFAB){
                notesViewModel.Insert(note)
            } else{
                notesViewModel.Update(note)
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun init(){
        noteDatabase = NoteDatabase(this)
        repo = Repo(noteDatabase.getNoteDao())
        notesViewModelFactory = NotesViewModelFactory(repo)
        notesViewModel = ViewModelProvider(this,notesViewModelFactory).get(NotesViewModel::class.java)
        rv = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)
    }

    override fun updateNote(note : NoteClass) {
        //logic of deleting note
        openDialog(comingFromFAB = false)
    }

    override fun deleteNote(note: NoteClass) {
        notesViewModel.Delete(note)
    }
}