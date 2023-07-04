package com.example.brainoidtechtest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.brainoidtechtest.ModelClass.MenuItem
import com.example.brainoidtechtest.R
import com.example.brainoidtechtest.databinding.ImageViewBinding
import com.squareup.picasso.Picasso

class ImageAdatper(val BookList: ArrayList<MenuItem>)  : RecyclerView.Adapter<ImageAdatper.ImageViewHolder>() {

    interface SetOnclickListener{
        fun setOnClick(position: Int)
    }
    var setOnclickListener : SetOnclickListener? = null

    fun setOnClickListener(listener: SetOnclickListener){
        setOnclickListener = listener
    }
    inner class ImageViewHolder(view: View):RecyclerView.ViewHolder(view){
      val binding : ImageViewBinding
      init {

          binding = ImageViewBinding.bind(view)
          view.setOnClickListener {
              setOnclickListener?.setOnClick(adapterPosition)
          }

      }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_view, null))
    }

    override fun getItemCount() = BookList.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val book = BookList[position]
        holder.binding.txttitle.text = "${book.title}"

            Picasso.get()
                .load(book.image)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.binding.imgView)
    }
}