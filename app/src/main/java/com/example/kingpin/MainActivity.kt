package com.example.kingpin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.kingpin.Adapters.ViewpagerAdapter
import com.example.kingpin.repo.SkillViewModel
import com.example.kingpin.ui.FormActivity
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val submitButton = findViewById<Button>(R.id.submit_button)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        setSupportActionBar(toolbar)


        val vpAdapter = ViewpagerAdapter(supportFragmentManager)
        viewPager.adapter = vpAdapter

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.text = "Top skill IQ"
        tabLayout.getTabAt(1)?.text = "Learning Leaders"

        submitButton.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }


    }
}