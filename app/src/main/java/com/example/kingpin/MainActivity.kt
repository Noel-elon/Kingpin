package com.example.kingpin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kingpin.repo.SkillViewModel

class MainActivity : AppCompatActivity() {
    lateinit var vm: SkillViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.hello)

        vm = ViewModelProvider(this).get(SkillViewModel::class.java)
        vm.getHoursList()
        vm.hourList.observe(this, Observer {
            val txt = it.toString()
            tv.text = txt
        })


    }
}