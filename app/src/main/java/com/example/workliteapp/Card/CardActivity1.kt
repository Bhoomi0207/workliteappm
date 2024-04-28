package com.example.workliteapp.Card


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import com.example.workliteapp.R
import com.example.workliteapp.databinding.ActivityCard1Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


class CardActivity1 : AppCompatActivity() {
    private lateinit var option: String

    private lateinit var binding: ActivityCard1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCard1Binding.inflate(layoutInflater)
        setContentView(binding.root)


       /* val spinner = findViewById<Spinner>(R.id.spinnerGender)

        val cOptions = arrayOf(
            "Please select your job type ",
            "Chef",
            "Sweeper",
            "Nanny",
            "Laundary",
            "Gardener",
            "Household"
        )


        val adapter = ArrayAdapter(this, R.layout.spinner_item, cOptions)
        adapter.setDropDownViewResource(R.layout.dropdown_item)
        spinner.adapter = adapter
        spinner.setSelection(0)
        var isGenderSelected = false
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // Check if a valid selection (not the hint) is made
                if (position != 0) {
                    isGenderSelected = true
                    option = cOptions[position] // Capture the selected gender
                } else {
                    isGenderSelected = false
                    option = "" // Reset gender when nothing is selected
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                Toast.makeText(this@CardActivity1, "Please select a category", Toast.LENGTH_SHORT)
                    .show()
            }
        }*/

               binding.submitButton.setOnClickListener {
           validateData()
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
        val db = Firebase.firestore.collection("job2")
        val key = db.document().id

        val data = addCardModel(
            binding.fullNameEditText.text.toString(),
            binding.addressEditText.text.toString(),
            binding.phoneEditText.text.toString(),

           binding.registerPasswordEditText.text.toString(),


        )
        db.document(key).set(data).addOnSuccessListener {
         //   dialog.dismiss()

            Toast.makeText(this, "Details added", Toast.LENGTH_SHORT).show()
            binding.fullNameEditText.text = null
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








