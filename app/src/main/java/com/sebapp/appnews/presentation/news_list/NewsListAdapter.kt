package com.sebapp.appnews.presentation.news_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import appnews.databinding.LayoutNewsItemBinding
import coil.load
import com.sebapp.appnews.domain.model.Results

/**
 *   17,junio,2022
 *
 * Created by
 *           Sebastian Pratto (Misiones, Arg.)
 */

class NewsListAdapter : ListAdapter<Results, NewsListAdapter.NewsViewHolder>(NewsDiffUtil) {

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

        private val title = itemBinding.textViewTitle
        private val image = itemBinding.imageViewThumbnail
        private val date = itemBinding.textViewDate

        private var currentNews: Results? = null

        init {
            itemView.setOnClickListener {
                currentNews?.let { news ->
                    onItemClickListener?.let {
                        it(news.id)
                    }
                }
            }
        }

        fun bind(news: Results) {

            currentNews = news

            if(news.id.isNotEmpty()) {
                title.text = news.webTitle
                image.load(news.fields.thumbnail)
                date.text = news.webPublicationDate.replace("T","").replace("Z"," ")
            }

        }

    }

}

object NewsDiffUtil: DiffUtil.ItemCallback<Results>() {
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}