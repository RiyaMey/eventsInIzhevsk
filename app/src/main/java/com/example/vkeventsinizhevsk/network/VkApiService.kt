package com.example.vkeventsinizhevsk.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// https://api.vk.com/method/users.get?user_id=210700286&v=5.131
private const val BASE_URL = "https://api.vk.com/method/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface VkApiService {
    @GET("users.get?user_id=210700286&v=5.131")
    suspend fun getEvents()
}

object VkApi {
    val retrofitService: VkApiService by lazy {
        retrofit.create(VkApiService::class.java)
    }
}