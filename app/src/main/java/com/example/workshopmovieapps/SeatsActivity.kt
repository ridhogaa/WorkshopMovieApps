package com.example.workshopmovieapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshopmovieapps.adapter.SeatAdapter
import com.example.workshopmovieapps.adapter.SeatDescAdapter
import com.example.workshopmovieapps.data.Seat
import com.example.workshopmovieapps.data.generateSeat
import com.example.workshopmovieapps.data.getVoucherList
import com.example.workshopmovieapps.databinding.ActivitySeatsBinding
import java.text.NumberFormat
import java.util.Locale

class SeatsActivity : AppCompatActivity() {

    private val seatList: MutableList<Seat> = mutableListOf()

    private var _binding: ActivitySeatsBinding? = null
    private val binding get() = _binding!!
    private val seatAdapter: SeatAdapter by lazy {
        SeatAdapter {
            if (it.isSelected && !it.isBooked) {
                seatList.add(it)
            } else {
                seatList.remove(it)
            }
            setUpSumSeatAndPrice()
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
        toDetail()
    }

    private fun toDetail() {
        binding.ivBack.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
        }
    }

    private fun setUpSumSeatAndPrice() = binding.run {
        if (seatList.isNotEmpty()) {
            tvCountSeat.text = seatList.count().toString() + " Kursi"
            tvSumSeat.text = formatRupiah((seatList.count() * 50_000).toDouble())
        } else {
            tvCountSeat.text = "0 Kursi"
            tvSumSeat.text = "Rp. 0"
        }
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

    fun formatRupiah(amount: Double): String {
        val localeID = Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        numberFormat.maximumFractionDigits = 0 // To avoid decimal places
        val formattedAmount = numberFormat.format(amount)
        return formattedAmount.replace("Rp", "Rp. ")
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}