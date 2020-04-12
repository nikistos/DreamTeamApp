package com.example.dreamteamapp

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerPersonalPageAdapter(fragment: Fragment, private val personIndex: Int): FragmentStateAdapter(fragment) {

    private val tabCount = 3

    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> InfoFragment.newInstance(personIndex)
            1 -> JobListFragment.newInstance(personIndex)
            else -> ContactsFragment.newInstance(personIndex)
        }
    }
}