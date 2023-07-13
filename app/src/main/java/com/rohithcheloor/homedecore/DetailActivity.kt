package com.rohithcheloor.homedecore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var product = intent.getSerializableExtra("product") as Product
        var cart = intent.getSerializableExtra("cart") as Cart

        val productNameTextView: TextView = findViewById(R.id.productName)
        val productPriceTextView: TextView = findViewById(R.id.productPrice)
        val productImageImageView: ImageView = findViewById(R.id.product_image)
        val productDescriptionTextView: TextView = findViewById(R.id.productDescription)
        val buyButton: Button = findViewById(R.id.buyButton)

        productNameTextView.text = product.name
        productPriceTextView.text = product.price
        productDescriptionTextView.text = product.description

        Glide.with(this)
            .load(Uri.parse(product.image))
            .into(productImageImageView)


        buyButton.setOnClickListener {
          cart.addItem(product)
            finish()
        }
    }
}
