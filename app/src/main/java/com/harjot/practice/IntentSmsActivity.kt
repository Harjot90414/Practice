package com.harjot.practice

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityIntentEmailBinding
import com.harjot.practice.databinding.ActivityIntentSmsBinding

class IntentSmsActivity : AppCompatActivity() {
    val binding : ActivityIntentSmsBinding by lazy {
        ActivityIntentSmsBinding.inflate(layoutInflater)
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
            if(binding.etPhoneNo.text.toString().trim().isNullOrEmpty()){
                binding.etPhoneNo.error = "Enter Phone no"
            }
            else if(binding.etSms.text.toString().trim().isNullOrEmpty()){
                binding.etSms.error = "Enter SMS"
            }
            else{
               var intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:${binding.etPhoneNo.text.toString()}"))
                intent.putExtra(Intent.EXTRA_TEXT,binding.etSms.text.toString())
                startActivity(intent)
            }
        }
    }
}