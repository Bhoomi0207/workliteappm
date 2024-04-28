package com.example.workliteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkAdapter(private val workList: List<WorkEntry>) :
    RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {

    inner class WorkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val workTextView: TextView = itemView.findViewById(R.id.workTextView)
        val wagesTextView: TextView = itemView.findViewById(R.id.wagesTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return WorkViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        val currentItem = workList[position]

        holder.dateTextView.text = currentItem.date
        holder.timeTextView.text = currentItem.time
        holder.workTextView.text = currentItem.work
        holder.wagesTextView.text = currentItem.wages
    }

    override fun getItemCount() = workList.size
}