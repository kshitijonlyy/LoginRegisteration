package com.kshitij.loginregisteration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kshitij.loginregisteration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            if (binding.userName.text.toString().isNullOrEmpty()){
                binding.userName.error = "This is a required field"
                binding.userName.requestFocus()
            }
            else if (binding.userPass.text.toString().length<8){
                binding.userPass.error = "Weak Password"
                binding.userPass.requestFocus()
            }else{
                var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", binding.userName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}