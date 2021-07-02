package com.danisable.apptablayoutviewpagerbottomnavigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.danisable.apptablayoutviewpagerbottomnavigation.adapter.ViewPageAdapter
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.FunFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.HomeFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.NewsFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class MainActivity : AppCompatActivity(), OnTabSelectedListener,  BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(FunFragment(),"",this)
        bottomNavigation.setOnNavigationItemSelectedListener(this)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home -> replaceFragment(HomeFragment(),"This value Fragment Home",this)
            R.id.menu_news -> replaceFragment(NewsFragment(),"This value Fragment News",this)
            R.id.menu_settings -> replaceFragment(SettingsFragment(),"This value Fragment Settings",this)
        }
        return false
    }



    private fun replaceFragment(fragment: Fragment, message: String, context: Context){
        val sm = supportFragmentManager.beginTransaction()
        sm.apply {
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)




            /*val bundle = Bundle()
            bundle.putString("message", message)
            fragment.arguments = bundle*/

            /*fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("One"))
            fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("Two"))
            fragment.tabLayout.addTab(fragment.tabLayout.newTab().setText("Three"))
            fragment.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
            val adapter = ViewPageAdapter(context, supportFragmentManager, fragment.tabLayout.tabCount)
            fragment.container.adapter = adapter

            fragment.tabLayout.addOnTabSelectedListener( context)
            fragment.tabLayout.setupWithViewPager(fragment.container)*/

            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }


    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        TODO("Not yet implemented")
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        //viewPager.currentItem = tab!!.position
    }

}