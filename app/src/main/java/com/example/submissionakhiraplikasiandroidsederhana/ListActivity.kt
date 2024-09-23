package com.example.submissionakhiraplikasiandroidsederhana

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    private lateinit var rvArtist: RecyclerView
    private val list = ArrayList<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        if (supportActionBar != null) {
            supportActionBar!!.title = "Home";
        }

        rvArtist = findViewById(R.id.rv_artist)
        rvArtist.setHasFixedSize(true)

        list.addAll(getListArtist())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListArtist(): ArrayList<Artist> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPlace = resources.getStringArray(R.array.data_place)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataJoined = resources.getStringArray(R.array.data_joined)
        val dataTotalSpotifyStreams = resources.getStringArray(R.array.data_total_spotify_streams)
        val dataTotalYoutubeStreams = resources.getStringArray(R.array.data_total_youtube_streams)
        val datadescription = resources.getStringArray(R.array.data_description)
        val morePhoto1 = resources.obtainTypedArray(R.array.more_photo1)
        val morePhoto2 = resources.obtainTypedArray(R.array.more_photo2)
        val morePhoto3 = resources.obtainTypedArray(R.array.more_photo3)
        val dataTotalSpotifyFollowers =
            resources.getStringArray(R.array.data_total_spotify_followers)
        val dataTotalInstagramFollowers =
            resources.getStringArray(R.array.data_total_instagram_followers)
        val dataTotalYoutubeSubscribers =
            resources.getStringArray(R.array.data_total_youtube_subscribers)

        val listArtist = ArrayList<Artist>()

        for (i in dataName.indices) {
            val artist = Artist(
                dataName[i],
                dataPlace[i],
                dataPhoto.getResourceId(i, -1),
                dataJoined[i],
                dataTotalSpotifyStreams[i],
                dataTotalYoutubeStreams[i],
                datadescription[i],
                morePhoto1.getResourceId(i, -1),
                morePhoto2.getResourceId(i, -1),
                morePhoto3.getResourceId(i, -1),
                dataTotalSpotifyFollowers[i],
                dataTotalInstagramFollowers[i],
                dataTotalYoutubeSubscribers[i]
            )
            listArtist.add(artist)
        }

        return listArtist
    }

    private fun showRecyclerList() {
        rvArtist.layoutManager = LinearLayoutManager(this)
        val listArtistAdapter = ListArtistAdapter(list)
        rvArtist.adapter = listArtistAdapter
    }
}