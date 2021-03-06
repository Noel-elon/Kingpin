package com.example.kingpin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kingpin.Adapters.HoursAdapter
import com.example.kingpin.R
import com.example.kingpin.repo.SkillViewModel

class HourFragment : Fragment() {
    private lateinit var adapter: HoursAdapter
    private lateinit var vm: SkillViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hour, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.hourRV)

        linearLayoutManager = LinearLayoutManager(context)


        vm = ViewModelProvider(this).get(SkillViewModel::class.java)
        vm.getHoursList()
        vm.hourList.observe(viewLifecycleOwner, Observer {
            adapter = HoursAdapter(it)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = linearLayoutManager
            adapter.notifyDataSetChanged()


        })
        return view
    }


}