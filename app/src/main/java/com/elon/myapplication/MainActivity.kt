package com.elon.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elon.myapplication.ui.theme.FareTheme

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Razorpay (replace with your actual API key)
        val razorpay = Razorpay(this)
        razorpay.setKey("YOUR_RAZORPAY_API_KEY")

        val payButton: Button = findViewById(R.id.payButton)
        payButton.setOnClickListener {
            // Create a payment order (replace with your actual order details)
            val orderRequest = OrderRequest()
            orderRequest.amount = 10 // Amount in paise (e.g., 1000 paise = ₹10)
            orderRequest.currency = "KES"
            orderRequest.receipt = "order123" // Unique order ID

            // Launch Razorpay checkout activity
            razorpay.open(orderRequest)


            razorpay.onPaymentSuccess { paymentId ->

            }

            razorpay.onPaymentError { code, description ->

            }
        }
    }
}