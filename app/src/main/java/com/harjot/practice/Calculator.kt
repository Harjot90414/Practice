package com.harjot.practice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityCalculatorBinding
import com.harjot.practice.databinding.ActivityMainBinding

class Calculator : AppCompatActivity() {
    val binding : ActivityCalculatorBinding by lazy {
        ActivityCalculatorBinding.inflate(layoutInflater)
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
        binding.btnAdd.setOnClickListener {
             binding.tvNumber.text="${binding.tvNumber.text.toString().toInt()+2}"
        }
        binding.btnMul.setOnClickListener {
            binding.tvNumber.text="${binding.tvNumber.text.toString().toInt()*2}"
        }
        binding.btnSub.setOnClickListener {
            binding.tvNumber.text="${binding.tvNumber.text.toString().toInt()-2}"
        }
        binding.btnDivide.setOnClickListener {
            binding.tvNumber.text="${binding.tvNumber.text.toString().toInt()/2}"
        }
        binding.btnNext.setOnClickListener {
            var intent = Intent(this,RelativeCardView::class.java)
            startActivity(intent)
        }
    }
}