package com.rohithcheloor.homedecore

import android.app.Activity
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ProductAdapter(options: FirebaseRecyclerOptions<Product>): FirebaseRecyclerAdapter<Product,ProductAdapter.MyViewHolder>(options) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
        model: Product
    ) {
        println(model.name)
        println(model.image)
        holder.prodName.text = model.name
        holder.prodPrice.text = model.price
        Glide.with(holder.itemView.context)
            .load(Uri.parse(model.image))
            .into(holder.prodImage);
    }
    class MyViewHolder(inflater: LayoutInflater,parent: ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.raw_layout,parent,false)){
        val prodName = itemView.findViewById<TextView>(R.id.product_name)
        val prodPrice = itemView.findViewById<TextView>(R.id.product_price)
        val prodImage = itemView.findViewById<ImageView>(R.id.product_image)
    }
}