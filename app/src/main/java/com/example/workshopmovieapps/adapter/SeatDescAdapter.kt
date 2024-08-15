package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.R
import com.example.workshopmovieapps.databinding.ItemDescSeatBinding

class SeatDescAdapter(private val itemClick: (String) -> Unit) :
    RecyclerView.Adapter<SeatDescAdapter.MenuSeatHolder>() {

    class MenuSeatHolder(
        private val binding: ItemDescSeatBinding,
        val itemClick: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: String) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    tvDescSeat.text = item
                    when (item) {
                        "Booked" -> {
                            btnSeat.setCardBackgroundColor(
                                ContextCompat.getColor(
                                    btnSeat.context,
                                    R.color.white
                                )
                            )
                        }

                        "Selected" -> {
                            btnSeat.setCardBackgroundColor(
                                ContextCompat.getColor(
                                    btnSeat.context,
                                    R.color.yellow
                                )
                            )
                            btnSeat.strokeColor = ContextCompat.getColor(
                                btnSeat.context,
                                R.color.yellow
                            )
                        }
                    }
                }
            }
        }
    }

    private var items: MutableList<String> = mutableListOf()

    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuSeatHolder {
        val binding =
            ItemDescSeatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuSeatHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MenuSeatHolder, position: Int) {
        holder.bindView(items[position])
    }
}