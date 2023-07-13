package com.rohithcheloor.homedecore

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class SuccessActivity : AppCompatActivity() {
    private lateinit var btnHome: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.success_page)

        btnHome = findViewById(R.id.btnHome)

        btnHome.setOnClickListener {

                startActivity(Intent(this, ProductActivity::class.java))
                finish() // Optional: Finish the current activity to prevent going back to the checkout screen
            }
    }
}
