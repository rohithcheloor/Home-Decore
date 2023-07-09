package com.rohithcheloor.homedecore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase

class HomeActivity : AppCompatActivity() {
    private var adapter: ProductAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val query = FirebaseDatabase.getInstance().reference.child("products")
        val options = FirebaseRecyclerOptions.Builder<Product>().setQuery(query, Product::class.java)
            .build()
        adapter = ProductAdapter(options)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        adapter = ProductAdapter(options)
        val rView: RecyclerView = findViewById(R.id.homeRecyclerView)
        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rView.adapter = adapter
    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }
}