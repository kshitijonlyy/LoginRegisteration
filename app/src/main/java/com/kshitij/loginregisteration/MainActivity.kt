package com.kshitij.loginregisteration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.kshitij.loginregisteration.databinding.ActivityMainBinding
import com.kshitij.loginregisteration.databinding.ActivitySecondBinding

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