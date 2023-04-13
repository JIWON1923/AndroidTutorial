package com.soi.mangocontentsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(val context: Context, val List: MutableList<ContentModel>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {

        if (itemClick != null) {
            holder.itemView.setOnClickListener { v->
                itemClick!!.onClick(v, position)
            }
        }

        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: ContentModel) {
            val title = itemView.findViewById<TextView>(R.id.recyclerViewTextArea)
            val image = itemView.findViewById<ImageView>(R.id.recyclerviewImageArea)

            title.text = item.titleText
            Glide.with(context)
                .load(item.imageURL)
                .into(image)

        }
    }
}