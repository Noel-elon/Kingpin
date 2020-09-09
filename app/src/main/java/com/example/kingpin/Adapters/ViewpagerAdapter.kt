package com.example.kingpin.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.kingpin.ui.HourFragment
import com.example.kingpin.ui.SkillFragment

class ViewpagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SkillFragment()
            else ->
                return HourFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}