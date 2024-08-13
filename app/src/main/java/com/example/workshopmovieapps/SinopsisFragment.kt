package com.example.workshopmovieapps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workshopmovieapps.adapter.CastAdapter
import com.example.workshopmovieapps.adapter.DateAdapter
import com.example.workshopmovieapps.data.getCastList
import com.example.workshopmovieapps.data.getScheduleList
import com.example.workshopmovieapps.databinding.FragmentSinopsisBinding


class SinopsisFragment : Fragment() {

    private var _binding: FragmentSinopsisBinding? = null
    private val binding get() = _binding!!
    private val castAdapter: CastAdapter by lazy {
        CastAdapter{

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSinopsisBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRvCast()
    }
    private fun setRvCast() = with(binding){
        rvCast.adapter = castAdapter
        rvCast.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        rvCast.setHasFixedSize(true)
        castAdapter.setItems(getCastList(requireContext()))
    }

}