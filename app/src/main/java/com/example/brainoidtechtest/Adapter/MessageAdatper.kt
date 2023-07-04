package com.example.brainoidtechtest.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.brainoidtechtest.ModelClass.AnnouncementDetail
import com.example.brainoidtechtest.R
import com.example.brainoidtechtest.databinding.MessagesViewBinding

class MessageAdatper(val BookList: ArrayList<AnnouncementDetail>) :
    RecyclerView.Adapter<MessageAdatper.MessageViewHolder>() {

    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: MessagesViewBinding

        init {
            binding = MessagesViewBinding.bind(view)

            view.setOnClickListener {


            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.messages_view, parent, false)
        )
    }

    override fun getItemCount() = BookList.size

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        val book = BookList[position]

        val layoutParams = holder.binding.cvMessageLayout.layoutParams as ViewGroup.MarginLayoutParams

        if (position % 2 == 0) {
            layoutParams.setMargins(100, 0, 0, 0)
        } else {
            layoutParams.setMargins(0, 0, 100, 0)
        }
        holder.binding.cvMessageLayout.layoutParams = layoutParams
        holder.binding.txtTitle.text = "${book.title} - ${book.title_date}"
        holder.binding.txtTitleDate.text = "${book.push_notification_subtitle}"

        holder.binding.txtDes.text = "${book.description}"
        holder.binding.txtReadMore .setOnClickListener(View.OnClickListener { view ->
            if (holder.binding.mainContainer .isVisible) {
                holder.binding.mainContainer .isGone = true
            } else {
                holder.binding.mainContainer .isVisible = true
            }
        })

    }
}