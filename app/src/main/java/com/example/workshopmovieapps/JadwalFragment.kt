package com.example.workshopmovieapps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshopmovieapps.adapter.DateAdapter
import com.example.workshopmovieapps.adapter.ScheduleAdapter
import com.example.workshopmovieapps.data.Date
import com.example.workshopmovieapps.data.getDateList
import com.example.workshopmovieapps.data.getScheduleList
import com.example.workshopmovieapps.databinding.FragmentJadwalBinding


class JadwalFragment : Fragment() {

    private var _binding: FragmentJadwalBinding? = null
    private val binding get() = _binding!!
    private val dateAdapter: DateAdapter by lazy {
        DateAdapter{

        }
    }
    private val scheduleAdapter: ScheduleAdapter by lazy {
        ScheduleAdapter{

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJadwalBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRvDate()
        setRvTime()
    }

    private fun setRvTime() = with(binding){
        rvSchedule.adapter = scheduleAdapter
        rvSchedule.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rvSchedule.setHasFixedSize(true)
        scheduleAdapter.setItems(getScheduleList(requireContext()))
    }

    private fun setRvDate() = with(binding){
        rvDate.adapter = dateAdapter
        rvDate.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rvDate.setHasFixedSize(true)
        dateAdapter.setItems(getDateList(requireContext()))
    }


}