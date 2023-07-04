package com.example.brainoidtechtest.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brainoidtechtest.Adapter.MessageAdatper
import com.example.brainoidtechtest.ApiService.ApiService
import com.example.brainoidtechtest.ModelClass.AnnouncementDetail
import com.example.brainoidtechtest.ModelClass.AnnouncementResponse
import com.example.brainoidtechtest.R
import com.example.brainoidtechtest.databinding.ActivityHomeBinding
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private lateinit var recycler_Message: RecyclerView

    private lateinit var messageAdatper: MessageAdatper

    private var ans = ArrayList<AnnouncementResponse>()

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recycler_Message = findViewById(R.id.recycler_Message)

        initDataAdapter()

       getMessageDetails()

    }


    fun initDataAdapter() {
        recycler_Message.layoutManager =
            LinearLayoutManager(this@HomeActivity, LinearLayoutManager.VERTICAL, false)

    }


    private fun getMessageDetails() {
        lifecycleScope.launch {
            try {
                val announcementResponse : AnnouncementResponse = ApiService.retrofit.getAllMessages()

                Log.e("ApiService", "${announcementResponse.toString()}")


                val list = ArrayList<AnnouncementDetail>()

                list.addAll(announcementResponse.announcements_details)

                binding.recyclerMessage.adapter = MessageAdatper(list)


            } catch (e: Exception) {
                Log.e("ApiService error", "${e.message}")
            }
        }
    }

}