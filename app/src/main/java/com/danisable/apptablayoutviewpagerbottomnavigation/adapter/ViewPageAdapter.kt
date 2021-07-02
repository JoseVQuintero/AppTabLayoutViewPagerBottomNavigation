package com.danisable.apptablayoutviewpagerbottomnavigation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.danisable.apptablayoutviewpagerbottomnavigation.R
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.HomeFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.OneFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.ThreeFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.TwoFragment


class ViewPageAdapter(
    private val context: HomeFragment,
    fn: FragmentManager,
    private val totalTabs:Int
) : FragmentPagerAdapter(fn, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> context.getString(R.string.nav_home_one)
            1 -> context.getString(R.string.nav_home_two)
            2 -> context.getString(R.string.nav_home_three)
            else -> context.getString(R.string.error_title)
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }

    override fun getCount(): Int = totalTabs

}