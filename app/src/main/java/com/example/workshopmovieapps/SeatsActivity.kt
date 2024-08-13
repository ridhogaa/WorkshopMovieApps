package com.example.workshopmovieapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshopmovieapps.adapter.SeatAdapter
import com.example.workshopmovieapps.adapter.SeatDescAdapter
import com.example.workshopmovieapps.data.generateSeat
import com.example.workshopmovieapps.data.getVoucherList
import com.example.workshopmovieapps.databinding.ActivitySeatsBinding

class SeatsActivity : AppCompatActivity() {

    private var _binding: ActivitySeatsBinding? = null
    private val binding get() = _binding!!
    private val seatAdapter: SeatAdapter by lazy {
        SeatAdapter {
        }
    }

    private val seatDescAdapter: SeatDescAdapter by lazy {
        SeatDescAdapter {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySeatsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.run {
            rvSeats.adapter = seatAdapter
            rvSeats.layoutManager = GridLayoutManager(
                this@SeatsActivity,
                11,
            )
            rvSeats.setHasFixedSize(true)
            seatAdapter.setItems(generateSeat())
            rvSeatsDesc.adapter = seatDescAdapter
            rvSeatsDesc.layoutManager =
                LinearLayoutManager(this@SeatsActivity, LinearLayoutManager.HORIZONTAL, false)
            rvSeatsDesc.setHasFixedSize(true)
            seatDescAdapter.setItems(listOf("Available", "Booked", "Selected"))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}