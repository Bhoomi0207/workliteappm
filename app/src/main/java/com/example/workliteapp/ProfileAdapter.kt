package com.example.workliteapp


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.workliteapp.Login.signinActivity
import com.example.workliteapp.databinding.LayoutProfileItemBinding

class ProfileAdapter(private val context: Context, private val list: List<ProfileItem>) :
    RecyclerView.Adapter<ProfileAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: LayoutProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = LayoutProfileItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.textView11.text = currentItem.name
        holder.binding.textView12.text = currentItem.phoneNumber
        holder.binding.imageView4.setImageResource(currentItem.imageResourceId)
        // Load image if you have any
        // Glide.with(context).load(currentItem.image).into(holder.binding.imageView4)

        // You can set click listeners or any other functionality here
        // holder.itemView.setOnClickListener { /* Handle item click */ }
        // Set click listener for WhatsApp chat
        holder.binding.imageView6.setOnClickListener {
            val phoneNumber =
                currentItem.phoneNumber // Assuming phoneNumber is a String field in your data object

            // Check if WhatsApp is installed

                val intent = Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber"));
                context.startActivity(intent);
            }

        holder.binding.imageView5.setOnClickListener {
            val name= currentItem.name

                val confirmationDialog = AlertDialog.Builder(context)
                    .setTitle("Shift change")
                    .setMessage("Are you sure you want to change your shift with $name?")
                    .setPositiveButton("Shift Change") { _, _ ->
                        Toast.makeText(context, "Shift Changed", Toast.LENGTH_SHORT)
                            .show()





                    }
                    .setNegativeButton("Cancel", null) // Do nothing on cancellation
                    .create()
                confirmationDialog.show()


        }
        }










    override fun getItemCount(): Int {
        return list.size
    }

}
