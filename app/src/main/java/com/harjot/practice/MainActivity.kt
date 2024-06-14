package com.harjot.practice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.harjot.practice.databinding.ActivityMainBinding
import com.harjot.practice.databinding.ActivitySecondBinding

class MainActivity : AppCompatActivity() {
     val binding : ActivityMainBinding by lazy {
         ActivityMainBinding.inflate(layoutInflater)
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "on create", Toast.LENGTH_SHORT).show()
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        binding.rbYes.setOnClickListener {
//            binding.etCollege.visibility = View.VISIBLE
//        }
//        binding.rbNo.setOnClickListener {
//            binding.etCollege.visibility = View.GONE
//        }
        binding.btnSmsIntent.setOnClickListener {
            var  intent = Intent(this,IntentSmsActivity::class.java)
            startActivity(intent)
        }
        binding.btnIntent.setOnClickListener {
            var  intent = Intent(this,IntentEmailActivity::class.java)
            startActivity(intent)
        }
        binding.btnAlertActivity.setOnClickListener {
            var intent = Intent(this,ALertDialogeActivity::class.java)
            startActivity(intent)
        }
        binding.rbYes.setOnCheckedChangeListener { ButtonView, isChecked ->
            if(isChecked){
                binding.etCollege.visibility = View.VISIBLE
            }else{
                binding.etCollege.setText("")
                binding.etCollege.visibility = View.GONE
            }
        }
        binding.btnMove.setOnClickListener{
            if(binding.etName.text.toString().trim().isNullOrEmpty()){
                binding.etName.error = "Enter name"
            }
            else if(binding.etNumber.text.toString().trim().isNullOrEmpty()){
                binding.etNumber.error = "Enter Number"
            }
            else if(binding.etDOB.text.toString().trim().isNullOrEmpty()){
                binding.etDOB.error = "Enter DOB"
            }
            else if(binding.etNumber.length()<10){
                binding.etNumber.error = "Enter Valid Number"
            }
            else if(binding.etDOB.text.toString().toInt() > 31 || binding.etDOB.text.toString().toInt() == 0){
                binding.etDOB.error = "Enter Valid Date"
            }
            else if(binding.rbYes.isChecked==false && binding.rbNo.isChecked==false){
                Toast.makeText(this, "select yes or no", Toast.LENGTH_SHORT).show()
            }
            else if(binding.etCollege.text.toString().trim().isNullOrEmpty() && binding.rbYes.isChecked==true){
                binding.etCollege.error = "Enter college"
            }
            else {
                var intent = Intent(this,SecondActivity::class.java)
                    .putExtra("name",binding.etName.text.toString())
                    .putExtra("number",binding.etNumber.text.toString())
                    .putExtra("dob",binding.etDOB.text.toString())
                if (binding.rbYes.isChecked){
                    intent.putExtra("study","Studying")
                    intent.putExtra("college",binding.etCollege.text.toString())
                }
                if (binding.rbNo.isChecked){

                    intent.putExtra("study","Not Studying")
                }
                startActivity(intent)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "on stop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "on restart", Toast.LENGTH_SHORT).show()
    }
}