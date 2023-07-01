package com.example.testing

import CreditCardViewModel
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: CreditCardViewModel by viewModels()

        setContent {
            CreditCardScreen(viewModel)



        }
    }
    }
@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val creditCards by viewModel.creditCards.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCards.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(creditCards.size) { index ->
                    val creditCard = creditCards[index]
                    Text(text=creditCard.userId)
                    Text(text = creditCard.title)
                    Text(text = creditCard.id)
                    Text(text = creditCard.body)
                    Divider() // Add a divider between items
                }
            }
        }
    }
}