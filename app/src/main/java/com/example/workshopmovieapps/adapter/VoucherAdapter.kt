package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.data.Voucher
import com.example.workshopmovieapps.databinding.ItemListMovieBinding
import com.example.workshopmovieapps.databinding.ItemListVoucherBinding

class VoucherAdapter(private val itemClick: (Voucher) -> Unit) :
    RecyclerView.Adapter<VoucherAdapter.MenuVoucherHolder>() {

    class MenuVoucherHolder(
        private val binding: ItemListVoucherBinding,
        val itemClick: (Voucher) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Voucher) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    ivVoucher.setImageResource(img)
                }
            }
        }
    }

    private var items: MutableList<Voucher> = mutableListOf()

    fun setItems(items:List<Voucher>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun addItems(items: List<Voucher>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuVoucherHolder {
        val binding = ItemListVoucherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuVoucherHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MenuVoucherHolder, position: Int) {
        holder.bindView(items[position])
    }

}