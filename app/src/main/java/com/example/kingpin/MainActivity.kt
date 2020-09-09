package com.example.kingpin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.kingpin.Adapters.ViewpagerAdapter
import com.example.kingpin.repo.SkillViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        setSupportActionBar(toolbar)

        val vpAdapter = ViewpagerAdapter(supportFragmentManager)
        viewPager.adapter = vpAdapter

        tabLayout.setupWithViewPager(viewPager)





    }
}