package com.harjot.practice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityCalculatorBinding
import com.harjot.practice.databinding.ActivityIntentEmailBinding

class IntentEmailActivity : AppCompatActivity() {
    val binding : ActivityIntentEmailBinding by lazy {
        ActivityIntentEmailBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnSend.setOnClickListener {
            if (binding.etEmail.text.toString().trim().isNullOrEmpty()){
                binding.etEmail.error = "Enter Email"
            }
            else if(binding.etSubject.text.toString().trim().isNullOrEmpty()){
                binding.etSubject.error = "Enter Subject"
            }
            else if(binding.etBody.text.toString().trim().isNullOrEmpty()){
                binding.etBody.error="Enter Body"
            }
            else{
                var intent = Intent(Intent.ACTION_SENDTO)
                    intent.data = Uri.parse("mailto:")
//                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(binding.etEmail.text.toString()))
                    intent.putExtra("subject",binding.etSubject.text.toString().trim())
                    intent.putExtra("body",binding.etBody.text.toString().trim())
//                    putExtra(Intent.EXTRA_STREAM,Uri.parse("mailto:${binding.etEmail.text.toString()}"))
                startActivity(intent)
            }
        }
    }
}