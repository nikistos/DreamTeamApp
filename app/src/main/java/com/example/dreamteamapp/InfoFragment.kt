package com.example.dreamteamapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import com.example.dreamteamapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private var personIndex: Int = 0

    companion object {

        private const val PERSON_INDEX = "PERSON_INDEX"

        fun newInstance(personIndex: Int): InfoFragment {
            return InfoFragment()
                .apply { arguments = bundleOf(PERSON_INDEX to personIndex) }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentInfoBinding>(
            inflater,
            R.layout.fragment_info, container, false
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
    }

    private fun fillUiWithData() {
        val currentPerson = MainActivity.dreamTeamList[personIndex]
        binding.educationGrade.text = currentPerson.educationGrade
        binding.educationYear.text = currentPerson.educationYear
        binding.universityName.text = currentPerson.universityName
        binding.langName.text = currentPerson.language.name
        binding.langCode.text = currentPerson.language.levelCode.toString()
        binding.langComment.text = currentPerson.language.getDecoding()
        binding.skillList.text = currentPerson.getInterestText()
    }
}
