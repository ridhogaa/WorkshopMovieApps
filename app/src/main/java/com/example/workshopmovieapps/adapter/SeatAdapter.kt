package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.R
import com.example.workshopmovieapps.data.Seat
import com.example.workshopmovieapps.databinding.ItemSeatBinding

class SeatAdapter(private val itemClick: (Seat) -> Unit) :
    RecyclerView.Adapter<SeatAdapter.MenuSeatHolder>() {

    class MenuSeatHolder(
        private val binding: ItemSeatBinding,
        val itemClick: (Seat) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Seat, isGone: Boolean) {
            with(item) {
                updateSeatAppearance(this)
                itemView.setOnClickListener {
                    isSelected = !isSelected
                    updateSeatAppearance(this)
                    itemClick(this)
                }
                binding.root.isVisible = !isGone
            }
        }

        private fun updateSeatAppearance(seat: Seat) {
            binding.run {
                when {
                    seat.isBooked -> {
                        setSeatAppearance(R.color.white, isEnabled = false)
                    }

                    seat.isSelected -> {
                        setSeatAppearance(R.color.yellow)
                    }

                    else -> {
                        setSeatAppearance(R.color.dark_blue)
                    }
                }
            }
        }

        private fun setSeatAppearance(colorRes: Int, isEnabled: Boolean = true) {
            binding.run {
                val color = ContextCompat.getColor(btnSeat.context, colorRes)
                btnSeat.setCardBackgroundColor(color)
                btnSeat.isEnabled = isEnabled
                if (!isEnabled) {
                    btnSeat.strokeColor = color
                }
            }
        }
    }

    private var items: MutableList<Seat> = mutableListOf()

    fun setItems(items: List<Seat>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuSeatHolder {
        val binding = ItemSeatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuSeatHolder(binding, itemClick)
    }

    private fun setUpSeats(position: Int): Boolean {
        return position == 0 || position == 5 || position == 10 ||
                position == 16 || position == 27 || position == 38 ||
                position == 49 || position == 60 || position == 71 ||
                position == 82 || position == 88 || position == 93 ||
                position == 98
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MenuSeatHolder, position: Int) {
        holder.bindView(items[position], setUpSeats(position))
    }
}