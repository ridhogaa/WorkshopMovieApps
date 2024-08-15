package com.example.workshopmovieapps

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.workshopmovieapps.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private var _binding: ActivityPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        payment()
    }

    private fun payment() {
        binding.materialButton.setOnClickListener {
            binding.icQr.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                binding.icQr.visibility = View.GONE
                binding.icPaymentSuccess.visibility = View.VISIBLE

                Handler(Looper.getMainLooper()).postDelayed({
                    binding.icPaymentSuccess.visibility = View.GONE
                    startActivity(Intent(this@PaymentActivity,MainActivity::class.java))
                    finish()
                },3000)
            },3000)
        }
    }
}