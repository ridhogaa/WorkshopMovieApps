package com.example.workshopmovieapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.workshopmovieapps.adapter.MovieAdapter
import com.example.workshopmovieapps.adapter.SectionsPagerAdapter
import com.example.workshopmovieapps.adapter.VoucherAdapter
import com.example.workshopmovieapps.data.getMovieList
import com.example.workshopmovieapps.data.getVoucherList
import com.example.workshopmovieapps.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter{

        }
    }
    private val voucherAdapter: VoucherAdapter by lazy {
        VoucherAdapter{

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchView()
        setRvMovie()
        setRvVoucher()
    }

    private fun setRvMovie() = with(binding){
        rvMovie.adapter = movieAdapter
        rvMovie.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL,false)
        rvMovie.setHasFixedSize(true)
        movieAdapter.setItems(getMovieList(this@MainActivity))
    }

    private fun setRvVoucher() = with(binding){
        rvVoucher.adapter = voucherAdapter
        rvVoucher.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        rvVoucher.setHasFixedSize(true)
        voucherAdapter.setItems(getVoucherList(this@MainActivity))
    }

    private fun searchView() {
        val searchIcon = binding.searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchIcon.setImageResource(R.drawable.ic_search)
        binding.searchView.queryHint = "Cari Film"

        val grey50 = ContextCompat.getColor(this, R.color.grey_50)
        val searchTextView = binding.searchView.findViewById<AutoCompleteTextView>(androidx.appcompat.R.id.search_src_text)
        searchTextView.setTextColor(grey50)

        val params = searchIcon.layoutParams
        params.height = resources.getDimensionPixelSize(R.dimen.icon_size_24dp)
        params.width = resources.getDimensionPixelSize(R.dimen.icon_size_24dp)
        searchIcon.layoutParams = params
    }

}