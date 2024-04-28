package com.example.workliteapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.util.CollectionUtils.listOf


class PayFragment : Fragment() {
    private val workList = listOf(
        WorkEntry("2024-04-28", "09:00 AM", "Outdoor Cleaning", "₹400"),
        WorkEntry("2024-04-27", "10:00 AM", "Cleaning Restrooms", "₹510"),
        WorkEntry("2024-04-26", "11:00 AM", "Sweeping floor", "₹680"),
        WorkEntry("2024-04-25", "10:00 AM", "Meal Preparation", "₹800"),
        WorkEntry("2024-04-24","11:00 AM", "Laundary", "₹400"),
        WorkEntry("2024-04-23","12:00 PM","Watering","₹500"),
        WorkEntry("2024-04-22","1:00 PM","Garbage disposal","₹500"),
        WorkEntry("2024-04-21","4:00 PM","Cleaning","₹600"),
        WorkEntry("2024-04-20","3:00 PM","Outdoor Cleaning","₹390",),
        WorkEntry("2024-04-19", "09:00 AM", "Laundary", "₹520"),
        WorkEntry("2024-04-18", "11:00 AM", "Sweeping floor", "₹600"),
        WorkEntry("2024-04-17", "10:00 AM", "Outdoor Cleaning", "₹620"),
        WorkEntry("2024-04-16","11:00 AM", "Meal Preparation", "₹500"),
        WorkEntry("2024-04-15","4:00 PM","Laundary","₹600"),
        WorkEntry("2024-04-14","3:00 PM","Sweeping floor","₹700",),
        WorkEntry("2024-04-13", "09:00 AM", "Outdoor Cleaning", "₹800"),
        WorkEntry("2024-04-12", "10:00 AM", "Meal Preparation", "₹700"),
        WorkEntry("2024-04-11","11:00 AM", "Laundary", "₹920"),
        WorkEntry("2024-04-10","12:00 PM","Sweeping floor","₹720"),
        WorkEntry("2024-04-09","1:00 PM","Meal Preparation","₹520"),
        WorkEntry("2024-04-08","4:00 PM","Outdoor Cleaning","₹800"),


    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pay, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val adapter = WorkAdapter(workList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}