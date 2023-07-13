package com.rohithcheloor.homedecore

import android.content.Intent
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
        super.onCreate(savedInstanceState)
        val query = FirebaseDatabase.getInstance().reference.child("products")
        val options = FirebaseRecyclerOptions.Builder<Product>()
            .setQuery(query, Product::class.java)
            .build()

        setContentView(R.layout.activity_product)
        val checkoutBtn = findViewById<Button>(R.id.checkoutBtn)
        checkoutBtn.isVisible = false
        adapter = ProductAdapter(options,this.cart, object : ProductAdapter.OnCartUpdateListener{
            override fun onCartUpdate() {
                checkoutBtn.text = "Checkout (${cart.getCartCount()})"
                checkoutBtn.isVisible = cart.getCartCount() > 0
            }
        val rView: RecyclerView = findViewById(R.id.homeRecyclerView)
        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rView.adapter = adapter

        checkoutBtn.setOnClickListener {
            if (cart.getCartCount() > 0) {
                startActivity(Intent(this@ProductActivity, CheckoutActivity::class.java))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}
