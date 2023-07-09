package com.rohithcheloor.homedecore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton: Button = findViewById(R.id.loginBtn)
        loginButton.setOnClickListener { this.onLoginClicked() }
    }

    private fun onLoginClicked(){
        val intent = Intent(this@LoginActivity, ProductActivity::class.java)
        startActivity(intent)
        finish()
    }
}