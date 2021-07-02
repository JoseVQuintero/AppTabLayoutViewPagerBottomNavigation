package com.danisable.apptablayoutviewpagerbottomnavigation.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.Fragment
import com.danisable.apptablayoutviewpagerbottomnavigation.R
import com.danisable.apptablayoutviewpagerbottomnavigation.adapter.TabsPagerAdapter
import com.danisable.apptablayoutviewpagerbottomnavigation.adapter.pager.TabsFun
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_fun.*
import kotlinx.android.synthetic.main.fragment_fun.view.tab_layout
import kotlinx.android.synthetic.main.fragment_fun.view.tabs_viewpager

class FunFragment: Fragment(),TabLayout.OnTabSelectedListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fun, container, false)

        // Tabs Customization
        view.tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        view.tab_layout.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorPrimaryDark))
        view.tab_layout.tabTextColors = ContextCompat.getColorStateList(view.context, android.R.color.white)

        // Set different Text Color for Tabs for when are selected or not
        //tab_layout.setTabTextColors(R.color.normalTabTextColor, R.color.selectedTabTextColor)

        // Number Of Tabs
        val numberOfTabs = 3

        // Set Tabs in the center
        //tab_layout.tabGravity = TabLayout.GRAVITY_CENTER

        // Show all Tabs in screen
        view.tab_layout.tabMode = TabLayout.MODE_FIXED

        // Scroll to see all Tabs
        //tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        // Set Tab icons next to the text, instead above the text
        view.tab_layout.isInlineLabel = true

        // Set the ViewPager Adapter
        val adapter = TabsFun(childFragmentManager, lifecycle, numberOfTabs)
        view.tabs_viewpager.adapter = adapter

        // Enable Swipe
        view.tabs_viewpager.isUserInputEnabled = true

        // Link the TabLayout and the ViewPager2 together and Set Text & Icons
        TabLayoutMediator(view.tab_layout, view.tabs_viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Music"
                    tab.setIcon(R.drawable.ic_music)
                }
                1 -> {
                    tab.text = "Movies"
                    tab.setIcon(R.drawable.ic_movie)

                }
                2 -> {
                    tab.text = "Books"
                    tab.setIcon(R.drawable.ic_book)
                }

            }
            // Change color of the icons
            tab.icon?.colorFilter =
                BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    Color.WHITE,
                    BlendModeCompat.SRC_ATOP
                )
        }.attach()

        return view
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }
}