package com.sebapp.naranjaxchallenge.presentation.news_detail

import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import coil.load
import com.sebapp.naranjaxchallenge.R
import com.sebapp.naranjaxchallenge.databinding.FragmentNewsDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class NewsDetailFragment : Fragment() {

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsDetailViewModel by navGraphViewModels(R.id.newsDetailFragment_graph) {
        defaultViewModelProviderFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageViewArrowBack.setOnClickListener { findNavController().popBackStack() }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.news.collect {
                it?.let { newsItem ->

                    binding.textViewDate.setText(newsItem.webPublicationDate.replace("T"," ").replace("Z", ""))
                    binding.imageViewThumbnail.load(newsItem.fields.thumbnail)
                    binding.textViewTitle.setText(newsItem.webTitle)
                    binding.textViewContent.setText(newsItem.fields.bodyText)

                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}