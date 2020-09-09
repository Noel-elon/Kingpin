package com.example.kingpin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kingpin.R
import com.example.kingpin.repo.SkillViewModel

class HourFragment : Fragment() {
    lateinit var vm: SkillViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_hour, container, false)
        val tv = view.findViewById<TextView>(R.id.tv)

        vm = ViewModelProvider(this).get(SkillViewModel::class.java)
        vm.getHoursList()
        vm.hourList.observe(this, Observer {
            tv.text = it.toString()

        })
        return view
    }


}