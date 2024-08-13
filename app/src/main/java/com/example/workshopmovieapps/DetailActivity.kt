package com.example.workshopmovieapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.workshopmovieapps.adapter.ScheduleAdapter
import com.example.workshopmovieapps.adapter.SectionsPagerAdapter
import com.example.workshopmovieapps.databinding.ActivityDetailBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.sinopsis,
            R.string.jadwal
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewPager()
    }


    private fun setViewPager() {
        val sectionPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabsLayout)
        TabLayoutMediator(tabs,viewPager){ tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        tabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.yellow))
        supportActionBar?.elevation = 0f
    }

}