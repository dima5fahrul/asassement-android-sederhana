package com.example.submissionakhiraplikasiandroidsederhana

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Detail";
        }

        val name = intent.getStringExtra("name")
        val place = intent.getStringExtra("place")
        val photo = intent.getIntExtra("photo", 0)
        val joined = intent.getStringExtra("joined")
        val totalSpotifyStreams = intent.getStringExtra("totalSpotifyStreams")
        val totalYoutubeStreams = intent.getStringExtra("totalYoutubeStreams")
        val totalSpotifyFollowers = intent.getStringExtra("totalSpotifyFollowers")
        val totalInstagramFollowers = intent.getStringExtra("totalInstagramFollowers")
        val totalYoutubeSubscribers = intent.getStringExtra("totalYoutubeSubscribers")
        val description = intent.getStringExtra("description")
        val morePhoto1 = intent.getIntExtra("morePhoto1", 0)
        val morePhoto2 = intent.getIntExtra("morePhoto2", 0)
        val morePhoto3 = intent.getIntExtra("morePhoto3", 0)

        // Tampilkan data pada layout
        findViewById<ImageView>(R.id.img_detail_photo).setImageResource(photo)
        findViewById<TextView>(R.id.tv_detail_artist_name).text = name
        findViewById<TextView>(R.id.tv_detail_place).text = place
        findViewById<TextView>(R.id.tv_detail_joined).text = joined
        findViewById<TextView>(R.id.tv_detail_total_spotify_stream).text = totalSpotifyStreams
        findViewById<TextView>(R.id.tv_detail_total_youtube_stream).text = totalYoutubeStreams
        findViewById<TextView>(R.id.tv_detail_total_spotify_followers).text = totalSpotifyFollowers
        findViewById<TextView>(R.id.tv_detail_total_instagram_followers).text =
            totalInstagramFollowers
        findViewById<TextView>(R.id.tv_detail_total_youtube_subscribers).text =
            totalYoutubeSubscribers
        findViewById<TextView>(R.id.tv_detail_biography).text = description
        findViewById<ImageView>(R.id.img_detail_more_photo1).setImageResource(morePhoto1)
        findViewById<ImageView>(R.id.img_detail_more_photo2).setImageResource(morePhoto2)
        findViewById<ImageView>(R.id.img_detail_more_photo3).setImageResource(morePhoto3)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}