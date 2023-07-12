package com.rohithcheloor.homedecore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Retrieve the product details passed from the previous activity
        val productName = intent.getStringExtra("productName")
        val productPrice = intent.getStringExtra("productPrice")
        val productImage = intent.getStringExtra("productImage")
        val productDescription = intent.getStringExtra("productDescription")

        // Bind the product details to the corresponding views
        val nameTextView: TextView = findViewById(R.id.productName)
        val priceTextView: TextView = findViewById(R.id.productPrice)
        val imageImageView: ImageView = findViewById(R.id.product_image)
        val descriptionTextView: TextView = findViewById(R.id.productDescription)
        val buyButton: Button = findViewById(R.id.buyButton)

        nameTextView.text = productName
        priceTextView.text = productPrice
        descriptionTextView.text = productDescription

        Glide.with(this)
            .load(Uri.parse(productImage))
            .into(imageImageView)

        // Set up the click listener for the "Buy Now" button
        buyButton.setOnClickListener {

            startActivity(intent)
        }
    }
}
