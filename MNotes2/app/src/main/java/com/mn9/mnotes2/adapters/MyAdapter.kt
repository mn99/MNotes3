package com.mn9.mnotes2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mn9.mnotes2.R
import com.mn9.mnotes2.models.Note

class MyAdapter(private val myDataset: ArrayList<Note>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val noteView: View) : RecyclerView.ViewHolder(noteView) {
        var note_title: TextView = noteView.findViewById(R.id.note_title) as TextView
        var note_body: TextView = noteView.findViewById(R.id.note_body) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val noteItem = myDataset[position]
        holder.note_title.text = noteItem.title
        holder.note_body.text = noteItem.value

        holder.noteView
    }

    override fun getItemCount() = myDataset.size
}