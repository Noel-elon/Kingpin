package com.example.kingpin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kingpin.Adapters.SkillAdapter
import com.example.kingpin.R
import com.example.kingpin.models.skillIQ
import com.example.kingpin.repo.SkillViewModel

class SkillFragment : Fragment() {
    private lateinit var adapter: SkillAdapter
    private lateinit var vm: SkillViewModel
    private lateinit var skillList: ArrayList<skillIQ>
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_skill, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.skillRV)
        linearLayoutManager = LinearLayoutManager(context)
        vm = ViewModelProvider(this).get(SkillViewModel::class.java)
        vm.getSkilliqList()
        vm.iqList.observe(this, Observer {
            adapter = SkillAdapter(it)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = linearLayoutManager
            adapter.notifyDataSetChanged()
        })




        return view
    }

}