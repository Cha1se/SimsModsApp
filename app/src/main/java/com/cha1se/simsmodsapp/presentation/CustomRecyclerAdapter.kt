package com.cha1se.simsmodsapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cha1se.domain.models.imgListModel
import com.cha1se.domain.models.titleListModel
import com.cha1se.simsmodsapp.R
import io.reactivex.disposables.Disposable

class CustomRecyclerAdapter(private val names: titleListModel, private val img: imgListModel) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameMod: TextView = itemView.findViewById(R.id.nameMod)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameMod.text =
            names.titlesList[position]
        holder.imageView.setImageBitmap(img.pictureList[position])
    }

    override fun getItemCount() = names.titlesList.size

}