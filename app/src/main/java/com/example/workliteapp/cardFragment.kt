package com.example.workliteapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workliteapp.Card.CardActivity1
import com.example.workliteapp.databinding.FragmentCardBinding


class cardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(layoutInflater)

        //  retrieveDataFromFirestore()


       /* val intent = Intent(context, CardActivity1::class.java)
        startActivity(intent)*/



        binding.cardview1.setOnClickListener {
            val intent = Intent(context, CardActivity1::class.java)
            startActivity(intent)
        }

        binding.cardview2.setOnClickListener {
            val intent = Intent(context, CardActivity1::class.java)
            startActivity(intent)
        }

        binding.cardview3.setOnClickListener {
            val intent = Intent(context, CardActivity1::class.java)
            startActivity(intent)
        }
        binding.cardview4.setOnClickListener {
            val intent = Intent(context, CardActivity1::class.java)
            startActivity(intent)
        }

        binding.cardview5.setOnClickListener {
            val intent = Intent(context, CardActivity1::class.java)
            startActivity(intent)
        }
        return (binding.root)
    }
}


