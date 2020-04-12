package com.example.dreamteamapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.dreamteamapp.databinding.FragmentLinkToPersonalPageBinding

class LinkToPersonalPageFragment : Fragment() {

    private lateinit var binding: FragmentLinkToPersonalPageBinding
    private var personIndex: Int = 0

    companion object {
        private const val PERSON_INDEX = "PERSON_INDEX"

        fun newInstance(personIndex: Int): LinkToPersonalPageFragment {
            return LinkToPersonalPageFragment()
                .apply { arguments = bundleOf(PERSON_INDEX to personIndex) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_link_to_personal_page,
            container,
            false
        )

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

        fillUiWithData()

        binding.buttonToPerson.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstPageFragment_to_personalPageFragment,
                PersonalPageFragment.newBundleWithPersonIndex(personIndex))
        }
    }

    private fun fillUiWithData() {
        binding.personNameWelcome.text = MainActivity.dreamTeamList[personIndex].getFullName()
        binding.welcomeUserPic.setImageDrawable(resources.getDrawable(MainActivity.dreamTeamList[personIndex].photoId))
    }
}