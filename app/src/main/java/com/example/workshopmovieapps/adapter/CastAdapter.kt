package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.data.Cast
import com.example.workshopmovieapps.databinding.ItemListCastBinding

class CastAdapter(private val itemClick:(Cast) -> Unit) :
    RecyclerView.Adapter<CastAdapter.CastHolder>(){

    class CastHolder(
        private val binding: ItemListCastBinding,
        val itemClick: (Cast) -> Unit
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Cast){
            with(item){
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    ivCast.setImageResource(img)
                }
            }
        }
    }

    private var items: MutableList<Cast> = mutableListOf()

    fun setItems(items:List<Cast>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun addItems(items: List<Cast>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAdapter.CastHolder {
        val binding = ItemListCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastAdapter.CastHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CastAdapter.CastHolder, position: Int) {
        holder.bindView(items[position])
    }
}