package com.mn9.mnotes3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mn9.mnotes3.R
import com.mn9.mnotes3.models.Note
import kotlinx.android.synthetic.main.note_item.view.*

class MyAdapter(private val myDataset: ArrayList<Note>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var listener: OnItemClickListener? = null

    inner class MyViewHolder(noteView: View) : RecyclerView.ViewHolder(noteView) {
        init {
            noteView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(myDataset[position])
                }
            }
        }
        var note_title: TextView = noteView.note_title
        var note_body: TextView = noteView.note_body
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val noteItem = myDataset[position]
        holder.note_title.text = noteItem.title
        holder.note_body.text = noteItem.body
    }

    fun getNoteAt(position: Int): Note {
        return myDataset[position]
    }

    override fun getItemCount() = myDataset.size

    fun addData(list: List<Note>) {
        myDataset.addAll(list)
    }

    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}