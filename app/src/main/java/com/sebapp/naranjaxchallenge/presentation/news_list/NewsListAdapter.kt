package com.sebapp.naranjaxchallenge.presentation.news_list

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sebapp.naranjaxchallenge.databinding.LayoutNewsItemBinding
import com.sebapp.naranjaxchallenge.domain.model.News

/**
 *   17,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

class NewsListAdapter : ListAdapter<News, NewsListAdapter.NewsViewHolder>(NewsDiffUtil) {

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutNewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)
    }

    inner class NewsViewHolder(
        itemBinding: LayoutNewsItemBinding
    ): RecyclerView.ViewHolder(itemBinding.root) {

        private val container = itemBinding.noteContainer
        private val title = itemBinding.textViewTitle
        private val image = itemBinding.imageViewThumbnail
        private val content = itemBinding.textViewContent

        private val backgroundColor = container.background as GradientDrawable
        private val strokeColor = container.background as GradientDrawable

        private var currentNews: News? = null

        init {
            itemView.setOnClickListener {
                currentNews?.let { news ->
                    onItemClickListener?.let {
                        it(news.id)
                    }
                }
            }
        }

        fun bind(news: News) {

            currentNews = news

            if(news.id.isNotEmpty()) {
                title.text = news.webTitle
                image.load(news.fields[0].thumbnail)
                content.text = news.fields[0].trailText
            }

        }

    }

}

object NewsDiffUtil: DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }
}