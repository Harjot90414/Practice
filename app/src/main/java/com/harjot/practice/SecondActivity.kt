package com.harjot.practice

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityMainBinding
import com.harjot.practice.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val binding : ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
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
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        val dob = intent.getStringExtra("dob")
        val study = intent.getStringExtra("study")
        val college = intent.getStringExtra("college")

        binding.tvName.text = name
        binding.tvNumber.text = number
        binding.tvDOB.text = dob
        binding.tvStudy.text = study

        if (college == null){
            binding.ll.visibility = View.GONE
        }
        else {
            binding.ll.visibility = View.VISIBLE
            binding.tvCollege.text = college
        }
        binding.btnBack.setOnClickListener {
            this.finish()
        }
    }
}