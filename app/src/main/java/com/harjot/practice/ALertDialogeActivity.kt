package com.harjot.practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityAlertDialogeBinding
import com.harjot.practice.databinding.ActivityCalculatorBinding

class ALertDialogeActivity : AppCompatActivity() {
    val binding : ActivityAlertDialogeBinding by lazy {
        ActivityAlertDialogeBinding.inflate(layoutInflater)
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
        binding.btnALert.setOnClickListener{
            var num = binding.etNumber.text.toString().trim()
            if (binding.etNumber.text.toString().trim().isNullOrEmpty()){
                binding.etNumber.error = "Enter Number"
            }
            else{
                AlertDialog.Builder(this).apply {
                    setTitle("Hello")
                    setMessage("Press ADD to add ${num} \nPress SUB to subtract ${num} \nPress 0 to reset")
                    setPositiveButton("ADD ${num}"){_,_->
                        binding.etNumber.setText("${binding.etNumber.text.toString().trim().toInt()+num.toInt()}")
                    }
                    setNegativeButton("SUB ${num}"){_,_->
                        binding.etNumber.setText("${binding.etNumber.text.toString().trim().toInt()-num.toInt()}")
                    }
                    setNeutralButton("0"){_,_->
                        binding.etNumber.setText("0")
                    }
                    show()
                }
            }
        }
    }
}