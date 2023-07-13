package com.rohithcheloor.homedecore

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.rohithcheloor.homedecore.Cart
import com.rohithcheloor.homedecore.Product
import com.rohithcheloor.homedecore.R


import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity







class CheckoutActivity : AppCompatActivity() {


    private lateinit var etName: EditText
    private lateinit var etAddress: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etCreditCard: EditText
    private lateinit var btnCheckout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_activity)

        // Initialize the views

        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etEmail = findViewById(R.id.etEmail)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etCreditCard = findViewById(R.id.etCreditCard)
        btnCheckout = findViewById(R.id.btnCheckout)




        btnCheckout.setOnClickListener {
            if (validateFields()) {
                // Fields are valid, proceed with checkout
                // Implement your checkout logic here

                // Example: Navigate to a success activity
                startActivity(Intent(this, SuccessActivity::class.java))
                finish() // Optional: Finish the current activity to prevent going back to the checkout screen
            }
        }
    }

    private fun validateFields(): Boolean {
        val name = etName.text.toString().trim()
        val address = etAddress.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val phoneNumber = etPhoneNumber.text.toString().trim()
        val creditCard = etCreditCard.text.toString().trim()

        // Perform validation on each field
        if (name.isEmpty()) {
            etName.error = "Please enter a name"
            etName.requestFocus()
            return false
        }

        if (address.isEmpty()) {
            etAddress.error = "Please enter an address"
            etAddress.requestFocus()
            return false
        }

        if (email.isEmpty()) {
            etEmail.error = "Please enter an email"
            etEmail.requestFocus()
            return false
        }

        if (phoneNumber.isEmpty()) {
            etPhoneNumber.error = "Please enter a phone number"
            etPhoneNumber.requestFocus()
            return false
        }

        if (creditCard.isEmpty()) {
            etCreditCard.error = "Please enter a credit card number"
            etCreditCard.requestFocus()
            return false
        }

        // Add additional validations as needed

        return true
    }
}
