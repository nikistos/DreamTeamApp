package com.example.dreamteamapp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class WelcomePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = MainActivity.dreamTeamList.count() + 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> WelcomeFragment()
            5 -> ByeFragment()
            else -> LinkToPersonalPageFragment.newInstance(position - 1)
        }
    }

}