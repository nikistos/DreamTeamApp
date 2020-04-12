package com.example.dreamteamapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.example.dreamteamapp.databinding.FragmentPersonalPageBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_personal_page.*

/**
 * A simple [Fragment] subclass.
 */
class PersonalPageFragment : Fragment() {

    private lateinit var binding: FragmentPersonalPageBinding
    private val tabTitles = listOf("ИНФО", "ОПЫТ", "КОНТАКТЫ")
    private var personIndex: Int = 0

    companion object {
        private const val PERSON_INDEX = "PERSON_INDEX"

        fun newInstance(personIndex: Int): PersonalPageFragment {
            return PersonalPageFragment()
                .apply { arguments = bundleOf(PERSON_INDEX to personIndex) }
        }

        fun newBundleWithPersonIndex(personIndex: Int) = bundleOf(PERSON_INDEX to personIndex)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentPersonalPageBinding>(inflater,
            R.layout.fragment_personal_page, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            personIndex = it.getInt(
                PERSON_INDEX,
                0
            )
        }
        binding.personName.text = MainActivity.dreamTeamList[personIndex].name
        viewPagerPerson.adapter = PagerPersonalPageAdapter(this, personIndex)
        TabLayoutMediator(tabLayout, viewPagerPerson) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        fillUiWithData()

    }

    private fun fillUiWithData() {
        binding.personName.text = MainActivity.dreamTeamList[personIndex].getFullName()
        binding.userPicture.setImageDrawable(resources.getDrawable(MainActivity.dreamTeamList[personIndex].photoId))
    }

}
