package com.example.testing.Services

import com.example.testing.Model.CreditCard

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}