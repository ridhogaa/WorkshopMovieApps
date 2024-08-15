package com.example.workshopmovieapps.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.workshopmovieapps.JadwalFragment
import com.example.workshopmovieapps.SinopsisFragment

class SectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position){
            0 -> fragment = SinopsisFragment()
            1 -> fragment = JadwalFragment()
        }
        return fragment as Fragment
    }

}