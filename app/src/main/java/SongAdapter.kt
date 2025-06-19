package com.example.newpracticum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newpracticum.databinding.ItemSongBinding

class SongAdapter(
    private val songs: List<String>,
    private val artists: List<String>,
    private val ratings: List<Int>,
    private val comments: List<String>
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {
    class SongViewHolder(val binding: ItemSongBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.binding.textTitle.text = songs[position]
        holder.binding.textArtist.text = artists[position]
        holder.binding.textRating.text = "Rating: ${ratings[position]}"
        holder.binding.textComment.text = comments[position]
    }

    override fun getItemCount() = songs.size
}
