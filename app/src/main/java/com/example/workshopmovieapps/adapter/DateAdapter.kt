package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.data.Date
import com.example.workshopmovieapps.databinding.ItemListDateBinding

class DateAdapter(private val itemClick: (Date) -> Unit) :
    RecyclerView.Adapter<DateAdapter.DateHolder>() {

    class DateHolder(
        private val binding: ItemListDateBinding,
        val itemClick: (Date) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Date) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    tvDate.text = date
                    tvDay.text = day
                }
            }
        }
    }

    private var items: MutableList<Date> = mutableListOf()

    fun setItems(items: List<Date>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Date>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateAdapter.DateHolder {
        val binding =
            ItemListDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateAdapter.DateHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DateAdapter.DateHolder, position: Int) {
        holder.bindView(items[position])
    }
}