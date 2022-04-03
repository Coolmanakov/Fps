package com.example.fps.features.chapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fps.R
import com.example.fps.databinding.ItemChapterBinding
import com.example.fps.models.Chapter

class ChapterAdapter(
    private val itemChapterListener: OnChapterItemClickListener
) : ListAdapter<Chapter, ChapterAdapter.ChapterViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate(inflater, R.layout.item_chapter, parent, false) as ItemChapterBinding
        return ChapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.bind()
    }

    private class DiffCallback : DiffUtil.ItemCallback<Chapter>() {

        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter) =
            oldItem == newItem
    }

    inner class ChapterViewHolder(private val binding: ItemChapterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind() {
            binding.chapterTitle.text = currentList[adapterPosition].name
            binding.chapterHolder.setOnClickListener {
                itemChapterListener.onItemClick(currentList[adapterPosition].name)
            }
        }
    }

}

interface OnChapterItemClickListener {
    fun onItemClick(chapterName: String)
}