package com.example.submissionakhiraplikasiandroidsederhana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    val name: String,
    val place: String,
    val photo: Int,
    val joined: String,
    val totalSpotifyStreams: String,
    val totalYoutubeStreams: String,
    val description: String,
    val morePhoto1: Int,
    val morePhoto2: Int,
    val morePhoto3: Int,
    val totalSpotifyFollowers: String,
    val totalInstagramFollowers: String,
    val totalYoutubeSubscribers: String,
) : Parcelable
