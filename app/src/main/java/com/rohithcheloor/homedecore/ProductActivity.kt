package com.rohithcheloor.homedecore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class ProductActivity : AppCompatActivity() {
    private var adapter: ProductAdapter? = null
    private var cart = Cart()
    override fun onCreate(savedInstanceState: Bundle?) {
        val query = FirebaseDatabase.getInstance().reference.child("products")
        val options = FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java)
            .build()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val checkoutBtn = findViewById<Button>(R.id.checkoutBtn)
        checkoutBtn.isVisible = false
        adapter = ProductAdapter(options,this.cart,object: ProductAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {

            }
        }, object : ProductAdapter.OnCartUpdateListener{
            override fun onCartUpdate() {
                checkoutBtn.text = "Checkout (${cart.getCartCount()})"
                checkoutBtn.isVisible = cart.getCartCount() > 0
            }
        })
        val rView: RecyclerView = findViewById(R.id.homeRecyclerView)
        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rView.adapter = adapter
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}