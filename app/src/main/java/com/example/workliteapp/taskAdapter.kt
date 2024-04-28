package com.example.workliteapp


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteapp.databinding.LayoutProfileItemBinding
import com.example.workliteapp.databinding.TaskLayoutitemBinding

class taskAdapter(private val context: Context, private val list: List<TaskItem>) :
    RecyclerView.Adapter<taskAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: TaskLayoutitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = TaskLayoutitemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.task1.text = currentItem.taskName
        holder.binding.taskDueDate1.text = currentItem.taskdate
        holder.binding.checkbox.isChecked = currentItem.isCompleted

        holder.binding.checkbox.setOnClickListener {
            val isChecked = holder.binding.checkbox.isChecked
            if (isChecked) {
                // Checkbox is checked, show a toast message
                Toast.makeText(holder.itemView.context, "Task completed!", Toast.LENGTH_SHORT).show()
            } else {
                // Checkbox is unchecked, show pending tasks
              //  showPendingTasks()
            }
        }




    }

    override fun getItemCount(): Int {
        return list.size
    }

}
