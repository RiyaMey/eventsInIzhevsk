package com.example.vkeventsinizhevsk.network

import com.squareup.moshi.Json

data class Event (
        val items: List<Item>,
        val count: Int
        )
data class Item (
        val id: String,
        val type: String,
        @Json(name="photo_200") val imgUrl: String,
        val description: String
        )