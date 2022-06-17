package com.sebapp.naranjaxchallenge.presentation.news_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sebapp.naranjaxchallenge.R
import com.sebapp.naranjaxchallenge.databinding.FragmentNewsListBinding
import javax.inject.Inject

class NewsListFragment : Fragment() {


    private var _binding: FragmentNewsListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var newsListAdapter: NewsListAdapter

    private val viewModel: NewsListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageViewDarkMode.setOnClickListener { viewModel.toggleDarkMode() }

        binding.imageViewLayoutList.setOnClickListener { viewModel.toggleLayoutMode() }

        binding.recyclerViewNews.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = newsListAdapter
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.newsList.collect { newsList ->
                newsListAdapter.submitList(newsList)
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.darkMode.collect { isDarkMode ->
                if(isDarkMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.linearLayoutMode.collect { isLinearLayout ->
                if(isLinearLayout) {
                    binding.imageViewLayoutList.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid)
                    )
                    binding.recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
                } else {
                    binding.imageViewLayoutList.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.ic_list)
                    )
                    binding.recyclerViewNews.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                }
            }
        }

        newsListAdapter.setOnItemClickListener { newsId ->

        }

    }



    override fun onResume() {
        super.onResume()
        viewModel.getNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}