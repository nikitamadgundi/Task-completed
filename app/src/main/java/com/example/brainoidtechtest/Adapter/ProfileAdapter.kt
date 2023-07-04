package com.example.brainoidtechtest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brainoidtechtest.ModelClass.Book
import com.example.brainoidtechtest.R
import com.example.brainoidtechtest.databinding.ProfileViewBinding
import com.squareup.picasso.Picasso

class ProfileAdapter (val BookList: ArrayList<Book>)  : RecyclerView.Adapter<ProfileAdapter.BookViewHolder>() {


    inner class  BookViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val binding : ProfileViewBinding

        init {
            view.setOnClickListener{

            }
            binding = ProfileViewBinding.bind(view)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.profile_view, parent,false))
    }

    override fun getItemCount() = BookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = BookList[position]
        holder.binding.txtName.text = "${book.book_name}"


        Picasso.get()
            .load(book.full_book_image)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(holder.binding.txtImage)
    }
}