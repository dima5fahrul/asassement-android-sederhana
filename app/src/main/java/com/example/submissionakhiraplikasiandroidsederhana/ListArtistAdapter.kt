package com.example.submissionakhiraplikasiandroidsederhana

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListArtistAdapter(private val listArtist: ArrayList<Artist>) :
    RecyclerView.Adapter<ListArtistAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvJoined: TextView = itemView.findViewById(R.id.tv_item_joined)
        val tvPlace: TextView = itemView.findViewById(R.id.tv_item_place)
        val tvTotalSpotifyStream: TextView =
            itemView.findViewById(R.id.tv_item_total_spotify_stream)
        val tvTotalYoutubeStream: TextView =
            itemView.findViewById(R.id.tv_item_total_youtube_stream)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_artist, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listArtist.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val artist = listArtist[position]

        holder.imgPhoto.setImageResource(artist.photo)
        holder.tvName.text = artist.name
        holder.tvJoined.text = "Joined: ${artist.joined}"
        holder.tvPlace.text = artist.place
        holder.tvTotalSpotifyStream.text = artist.totalSpotifyStreams
        holder.tvTotalYoutubeStream.text = artist.totalYoutubeStreams

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", artist.name)
            intent.putExtra("place", artist.place)
            intent.putExtra("photo", artist.photo)
            intent.putExtra("joined", artist.joined)
            intent.putExtra("totalSpotifyStreams", artist.totalSpotifyStreams)
            intent.putExtra("totalYoutubeStreams", artist.totalYoutubeStreams)
            intent.putExtra("totalSpotifyFollowers", artist.totalSpotifyFollowers)
            intent.putExtra("totalInstagramFollowers", artist.totalInstagramFollowers)
            intent.putExtra("totalYoutubeSubscribers", artist.totalYoutubeSubscribers)
            intent.putExtra("description", artist.description)
            intent.putExtra("morePhoto1", artist.morePhoto1)
            intent.putExtra("morePhoto2", artist.morePhoto2)
            intent.putExtra("morePhoto3", artist.morePhoto3)

            holder.itemView.context.startActivity(intent)
        }
    }
}