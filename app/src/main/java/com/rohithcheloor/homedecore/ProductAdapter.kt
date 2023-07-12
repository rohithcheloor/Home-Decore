package com.rohithcheloor.homedecore

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class ProductAdapter(options: FirebaseRecyclerOptions<Product>,private val cart: Cart, private val listener: OnItemClickListener, private val cartUpdateListener: OnCartUpdateListener): FirebaseRecyclerAdapter<Product,ProductAdapter.MyViewHolder>(options) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.raw_layout, parent, false)
        return MyViewHolder(inflater,parent)
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    interface OnCartUpdateListener {
        fun onCartUpdate()
    }
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int,
        model: Product
    ) {

        holder.prodName.text = model.name
        holder.prodPrice.text = model.price
        println(model.name)
        Glide.with(holder.itemView.context)
            .load(Uri.parse(model.image))
            .into(holder.prodImage)
        holder.prodAddToCart.setOnClickListener {
            cart.addItem(model)
            cartUpdateListener.onCartUpdate()
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("productName", model.name)
            intent.putExtra("productPrice", model.price)
            intent.putExtra("productImage", model.image)
            intent.putExtra("productDescription", model.description)
            holder.itemView.context.startActivity(intent)
        }
    }
    class MyViewHolder(inflater: LayoutInflater,parent: ViewGroup):RecyclerView.ViewHolder(inflater.inflate(R.layout.raw_layout,parent,false)){
        val prodName: TextView = itemView.findViewById<TextView>(R.id.product_name)
        val prodPrice: TextView = itemView.findViewById<TextView>(R.id.product_price)
        val prodImage: ImageView = itemView.findViewById<ImageView>(R.id.product_image)
        val prodAddToCart: Button = itemView.findViewById<Button>(R.id.product_buy_button)
    }
}