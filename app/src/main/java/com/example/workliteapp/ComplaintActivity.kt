package com.example.workliteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.workliteapp.Card.addCardModel
import com.example.workliteapp.databinding.ActivityCard1Binding
import com.example.workliteapp.databinding.ActivityComplaintBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ComplaintActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComplaintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplaintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            validateData()
        }
        binding.imageView10.setOnClickListener {
            Toast.makeText(this,"Satisfied!!",Toast.LENGTH_SHORT).show()
        }
        binding.imageView11.setOnClickListener {
            Toast.makeText(this,"Dissatisfied!!",Toast.LENGTH_SHORT).show()
        }
    }



    private fun validateData() {
        if (binding.fullNameEditText.text.toString().isEmpty()){
            binding.fullNameEditText.requestFocus()
            binding.fullNameEditText.error= "Empty"
        }else if (binding.addressEditText.text.toString().isEmpty()){
            binding.addressEditText.error = "Empty"


        }else{
            storeData()
        }
    }



    private fun storeData() {
        val db = Firebase.firestore.collection("complain")
        val key = db.document().id

        val data = addComplainModel(
            binding.fullNameEditText.text.toString(),
            binding.addressEditText.text.toString(),


            )
        db.document(key).set(data).addOnSuccessListener {
            //   dialog.dismiss()

            Toast.makeText(this, "File Complained", Toast.LENGTH_SHORT).show()
            binding.fullNameEditText.text = null
            binding.addressEditText.text=null
        }
            .addOnFailureListener { e ->
                //  dialog.dismiss()
                Log.e("FirebaseError", "Error adding category", e)
                Toast.makeText(
                    this,
                    "Something went wrong: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }


    }




}


