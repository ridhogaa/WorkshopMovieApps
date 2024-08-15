package com.example.workshopmovieapps.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.workshopmovieapps.DetailActivity
import com.example.workshopmovieapps.data.Movie
import com.example.workshopmovieapps.databinding.ItemListMovieBinding.inflate
import com.example.workshopmovieapps.databinding.ItemListMovieBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ListViewHolder>(){
    private val callback = object : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean =
            oldItem == newItem

    }
    val differ = AsyncListDiffer(this,callback)

    inner class ListViewHolder(private val binding: ItemListMovieBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind (item: Movie){
            binding.ivMovie.setImageResource(item.img)
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context,DetailActivity::class.java)
                binding.root.context.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ListViewHolder =
        ListViewHolder(inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.bind(differ.currentList[position])
}