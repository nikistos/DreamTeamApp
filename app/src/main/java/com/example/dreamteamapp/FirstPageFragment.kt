package com.example.dreamteamapp

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.contains
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_pager.*

/**
 * A simple [Fragment] subclass.
 */
class FirstPageFragment : Fragment() {


    lateinit var dotsList: MutableList<TextView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_pager, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dotsList = MutableList(6) {TextView(context)}
        pagerMenu.adapter = WelcomePagerAdapter(this)

        pagerMenu.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                dots.removeAllViews()
                addDotsIndicator(position)
                dotsList[position].setTextColor(resources.getColor(R.color.blond))
        }
        })
    }

    private fun addDotsIndicator(index: Int) {

        for (i in 0 until dotsList.count()) {
            dotsList[i] = TextView(context)
            dotsList[i].text = Html.fromHtml("&#8226")
            dotsList[i].textSize = 35f
            dotsList[i].setTextColor(resources.getColor(R.color.transparentWhite))
            dots.addView(dotsList[i])
        }
    }

}
