package com.example.notesapp

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.db.NoteClass

class NotesAdapter(
    private val listOfNotes : List<NoteClass>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(
        itemView : View
    ) : RecyclerView.ViewHolder(itemView){
        val textName : TextView = itemView.findViewById(R.id.NoteHeadline)
        val textContent : TextView = itemView.findViewById(R.id.NoteContent)
        val imgDelete : ImageView = itemView.findViewById(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_note,parent,false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = listOfNotes[position]
        holder.textName.text = currentNote.notename
        holder.textContent.text = currentNote.noteContent
    }
}