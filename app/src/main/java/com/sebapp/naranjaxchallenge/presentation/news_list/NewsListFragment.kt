package com.sebapp.naranjaxchallenge.presentation.news_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.sebapp.naranjaxchallenge.databinding.FragmentNewsListBinding
import javax.inject.Inject

class NewsListFragment : Fragment() {


    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var newListAdapter: NewsListAdapter

    private val viewModel: NewsListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

}