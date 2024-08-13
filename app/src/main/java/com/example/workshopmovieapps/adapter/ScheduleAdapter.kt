package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.data.Schedule
import com.example.workshopmovieapps.databinding.ItemListScheduleBinding

class ScheduleAdapter(private val itemClick:(Schedule) -> Unit) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>(){

    class ScheduleHolder(
        private val binding: ItemListScheduleBinding,
        val itemClick: (Schedule) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Schedule){
            with(item){
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    tvTime.text = time
                }
            }
        }
    }

    private var items: MutableList<Schedule> = mutableListOf()

    fun setItems(items:List<Schedule>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun addItems(items: List<Schedule>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleAdapter.ScheduleHolder {
        val binding = ItemListScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScheduleAdapter.ScheduleHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ScheduleHolder, position: Int) {
        holder.bindView(items[position])
    }
}