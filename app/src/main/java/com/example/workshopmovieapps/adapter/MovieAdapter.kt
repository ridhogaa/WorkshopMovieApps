package com.example.workshopmovieapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.data.Movie
import com.example.workshopmovieapps.databinding.ItemListMovieBinding

class MovieAdapter(private val itemClick: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MenuMovieHolder>() {

    class MenuMovieHolder(
        private val binding: ItemListMovieBinding,
        val itemClick: (Movie) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Movie) {
            with(item) {
                itemView.setOnClickListener { itemClick(this) }
                binding.run {
                    ivMovie.setImageResource(img)
                }
            }
        }
    }

    private var items: MutableList<Movie> = mutableListOf()

    fun setItems(items:List<Movie>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun addItems(items: List<Movie>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuMovieHolder {
        val binding = ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuMovieHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MenuMovieHolder, position: Int) {
        holder.bindView(items[position])
    }

}