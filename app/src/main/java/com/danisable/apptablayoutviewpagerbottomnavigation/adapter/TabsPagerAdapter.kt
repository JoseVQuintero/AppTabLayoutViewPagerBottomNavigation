package com.danisable.apptablayoutviewpagerbottomnavigation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.`fun`.BookFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.`fun`.MoviesFragment
import com.danisable.apptablayoutviewpagerbottomnavigation.fragment.tabs.`fun`.MusicFragment

class TabsPagerAdapter(
        fm: FragmentManager,
        lifecycle: Lifecycle,
        private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle)
{
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Music Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Music Fragment")
                val musicFragment = MusicFragment()
                musicFragment.arguments = bundle
                return musicFragment
            }
            1 -> {
                // # Movies Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Movies Fragment")
                val moviesFragment = MoviesFragment()
                moviesFragment.arguments = bundle
                return moviesFragment
            }
            2 -> {
                // # Books Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Books Fragment")
                val booksFragment = BookFragment()
                booksFragment.arguments = bundle
                return booksFragment
            }
            else -> return MusicFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }

}