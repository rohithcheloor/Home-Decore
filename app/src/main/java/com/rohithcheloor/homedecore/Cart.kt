package com.rohithcheloor.homedecore

class Cart {
    private val cartItems: MutableList<Product> = mutableListOf()
    fun addItem(item: Product) {
        cartItems.add(item)
    }

    fun removeItem(item: Product) {
        cartItems.remove(item)
    }

    fun getTotalPrice(): Double {
        var totalPrice = 0.0
        for (item in cartItems) {
            totalPrice += Integer.parseInt(item.price)
        }
        return totalPrice
    }

    fun getCartCount(): Int{
        return cartItems.count()
    }

    fun getCartItems(): List<Product> {
        return cartItems
    }
}