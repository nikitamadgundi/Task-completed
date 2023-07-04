package com.example.brainoidtechtest.ApiService

import com.example.brainoidtechtest.ModelClass.Announcement
import com.example.brainoidtechtest.ModelClass.AnnouncementResponse
import com.example.brainoidtechtest.ModelClass.Book
import com.example.brainoidtechtest.ModelClass.BookApiResponse
import com.example.brainoidtechtest.ModelClass.MenuItem
import com.example.brainoidtechtest.ModelClass.MenuResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService  {

    @GET("get-all-menu")
    suspend fun getAllImage(): MenuResponse

    @GET("get-all-books")
    suspend fun getAllBooks():BookApiResponse

    @GET("get-all-announcements")
    suspend fun getAllMessages() : AnnouncementResponse


    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://13.235.223.51/bookletapp/public/api/test_api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService :: class.java)
    }
}