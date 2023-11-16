package com.example.youtube.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.example.youtube.data.model.Item
import com.example.youtube.databinding.ItemPlaylistsBinding
import java.util.*

class PlaylistAdapterItem(private val onClick: (Item) -> Unit) :
    ListAdapter<Item, PlaylistAdapterItem.PlaylistViewHolder>(PlayListItemDiffUtil()) {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(liste: List<Item>) {
        this.list = liste as ArrayList<Item>
        notifyDataSetChanged()
    }

    private var list = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class PlaylistViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n", "CheckResult")
        fun bind(item: Item?) = with(binding) {
            Glide.with(itemView.context).load(item?.snippet?.thumbnails?.medium?.url)
                .into(image)
            image.load(item?.snippet?.thumbnails?.standard?.url)
            tvTitle.text = item?.snippet?.title
            tvTimeOfVideo.text = "${item?.contentDetails?.itemCount} video"

            itemView.setOnClickListener {
                onClick.invoke(item!!)
            }
        }
    }

    class PlayListItemDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
    }
}