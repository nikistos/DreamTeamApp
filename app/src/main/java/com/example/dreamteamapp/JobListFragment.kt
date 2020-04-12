package com.example.dreamteamapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dreamteamapp.databinding.FragmentInfoBinding
import com.example.dreamteamapp.databinding.FragmentJobExperienceBinding
import kotlinx.coroutines.Job

class JobListFragment : Fragment() {

    lateinit var binding: FragmentJobExperienceBinding
    private var personIndex: Int = 0

    companion object {

        private const val PERSON_INDEX = "PERSON_INDEX"

        fun newInstance(personIndex: Int): JobListFragment {
            return JobListFragment()
                .apply { arguments = bundleOf(PERSON_INDEX to personIndex) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentJobExperienceBinding>(
            inflater,
            R.layout.fragment_job_experience, container, false
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

        var adapter = JobRecyclerViewAdapter()
        adapter.data = MainActivity.dreamTeamList[personIndex].experience
        binding.jobListRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.jobListRecyclerView.adapter = adapter
    }
}