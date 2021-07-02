package com.danisable.apptablayoutviewpagerbottomnavigation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danisable.apptablayoutviewpagerbottomnavigation.R
import com.danisable.apptablayoutviewpagerbottomnavigation.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_home.view.viewPager

class HomeFragment : Fragment(), TabLayout.OnTabSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.tabLayout.addTab(view.tabLayout.newTab().setText("One"))
        view.tabLayout.addTab(view.tabLayout.newTab().setText("Two"))
        view.tabLayout.addTab(view.tabLayout.newTab().setText("Three"))

        view.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = ViewPageAdapter(this, childFragmentManager, view.tabLayout.tabCount)
        view.viewPager.adapter = adapter
        Log.e("TAG", view.tabLayout.tabCount.toString());
        view.tabLayout.addOnTabSelectedListener(this)
        view.tabLayout.setupWithViewPager(viewPager)

        return view
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        viewPager.currentItem = tab!!.position
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val data: Bundle = requireArguments()
        val message = data.getString("message")*/

        // tvMessage.text = message.toString()
    }*/


}