package com.example.workliteapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workliteapp.databinding.FragmentProfileBinding
import com.google.android.gms.common.util.CollectionUtils.listOf


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileItems = listOf(

            ProfileItem("Meena(मीना)",  "7706017030", R.drawable.woman12),
            ProfileItem("Deepa(दीपा)","6398581017", R.drawable.woman13),
            ProfileItem("Sonam(सोनम)", "9084243046", R.drawable.woman14),
            ProfileItem("Mahima(महिमा)", "8318427641", R.drawable.woman15),
            ProfileItem("Pratibha(प्रतिभा)", "9015768567", R.drawable.woman1),
            ProfileItem("Ragini(रागिनी)", "8874356772", R.drawable.woman2),
            ProfileItem("Sushila(सुशीला)", "6954302105", R.drawable.woman4),
            ProfileItem("Naina(नैना)",  "6392134091", R.drawable.woman5),
            ProfileItem("Vineeta(विनीता)","8764592061", R.drawable.woman6),
            ProfileItem("Poonam(पूनम)", "8313750129", R.drawable.woman7),
            ProfileItem("Sunita(सुनीता)", "6205672349", R.drawable.woman8),
            ProfileItem("Rohini(रोहिणी)", "8299789338", R.drawable.woman9),
            ProfileItem("Sapna(सपना)", "9693265100", R.drawable.woman10),
            ProfileItem("Pinki(पिंकी)", "7884356013", R.drawable.woman16),
            // Add more ProfileItems as needed
        )

        // Initialize adapter with the provided data
        adapter = ProfileAdapter(requireContext(), profileItems)

        // Set layout manager and adapter for RecyclerView
        binding.cartRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecycler.adapter = adapter
    }
}