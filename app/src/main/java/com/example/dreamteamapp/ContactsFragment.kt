package com.example.dreamteamapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.dreamteamapp.databinding.FragmentContactsBinding


class ContactsFragment : Fragment() {

    lateinit var binding: FragmentContactsBinding
    private var personIndex: Int = 0

    companion object {

        private const val PERSON_INDEX = "PERSON_INDEX"

        fun newInstance(personIndex: Int): ContactsFragment {
            return ContactsFragment()
                .apply { arguments = bundleOf(PERSON_INDEX to personIndex) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentContactsBinding>(
            inflater,
            R.layout.fragment_contacts, container, false
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
        makeLinks()
    }

    private fun fillUiWithData() {
        val currentPerson = MainActivity.dreamTeamList[personIndex]
        binding.email.text = currentPerson.email
        binding.phoneNumber.text = currentPerson.phoneNumber
        binding.vkPage.text = "@" + currentPerson.vkNick
    }

    private fun makeLinks() {

        binding.vkPage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(MainActivity.dreamTeamList[personIndex].getVkUrl())
            startActivity(intent)
        }

        binding.email.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(MainActivity.dreamTeamList[personIndex].getMailUrl())
            startActivity(intent)
        }

        binding.phoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(MainActivity.dreamTeamList[personIndex].getPhoneUri())
            startActivity(intent)
        }

        binding.hhPage.setOnClickListener {
            if (MainActivity.dreamTeamList[personIndex].hhUrl.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(MainActivity.dreamTeamList[personIndex].getHHUrl())
                startActivity(intent)
            }
        }
    }
}