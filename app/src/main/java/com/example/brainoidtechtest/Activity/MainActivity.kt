package com.example.brainoidtechtest.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brainoidtechtest.Adapter.ImageAdatper
import com.example.brainoidtechtest.Adapter.ProfileAdapter
import com.example.brainoidtechtest.ApiService.ApiService
import com.example.brainoidtechtest.ModelClass.Book
import com.example.brainoidtechtest.ModelClass.BookApiResponse
import com.example.brainoidtechtest.ModelClass.MenuItem
import com.example.brainoidtechtest.ModelClass.MenuResponse
import com.example.brainoidtechtest.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var profileAdapter: ProfileAdapter
    private lateinit var imageAdatper: ImageAdatper
    private lateinit var recycler_image: RecyclerView
    private var BookList: ArrayList<MenuItem> = ArrayList<MenuItem>()
    private var BookList1: ArrayList<Book> = ArrayList<Book>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getImageBook()
        getAllBooks()
    }

    fun getImageBook() {
        try {
            lifecycleScope.launch {
                val menuResponse: MenuResponse = ApiService.retrofit.getAllImage()
                Log.e("Api Calls", "${menuResponse.toString()}")
                BookList = menuResponse.menu as ArrayList<MenuItem>
                initDataAdapter()


            }
        } catch (e: Exception) {
            Log.e("Api calls", "${e.message}")
        }
    }

    fun initDataAdapter() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        imageAdatper = ImageAdatper(BookList)
        recyclerView.adapter = imageAdatper
        imageAdatper.setOnclickListener = SetOnClickListener()
    }

    fun getAllBooks() {
        try {
            lifecycleScope.launch {
                val bookApiResponse: BookApiResponse = ApiService.retrofit.getAllBooks()
                Log.e("Api Calls", "${bookApiResponse.toString()}")
                BookList1 = bookApiResponse.books as ArrayList<Book>
                initDataAdapterBook()




            }
        } catch (e: Exception) {
            Log.e("Api calls", "${e.message}")
        }
    }

    fun initDataAdapterBook() {
        recycler_image = findViewById(R.id.recycler_image)
        recycler_image.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        profileAdapter = ProfileAdapter(BookList1)
        recycler_image.adapter = profileAdapter
    }

    inner class SetOnClickListener : ImageAdatper.SetOnclickListener{
        override fun setOnClick(position: Int) {
            val intent  = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }

    }



}