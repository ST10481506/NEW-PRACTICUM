package com.example.newpracticum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newpracticum.databinding.ActivityDetailBinding

class ItemDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val songs = intent.getStringArrayListExtra("songs") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        if (songs.isEmpty()) {
            binding.textMessage.text = "No songs to display."
        } else {
            binding.recyclerView.adapter = SongAdapter(songs, artists, ratings, comments)
            binding.recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

            val avg = ratings.average()
            binding.textAverage.text = "Average Rating: %.2f".format(avg)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
