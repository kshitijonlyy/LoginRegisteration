package com.kshitij.loginregisteration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.kshitij.loginregisteration.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var userName : String
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let {
            userName = it.getStringExtra("name")?:"User"
            binding.msgWelcome.setText(binding.msgWelcome.text.toString()+" "+userName)
        }

        binding.txtOther.visibility = View.GONE
        binding.radiogrp.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.gMale->{
                    Toast.makeText(this,"he/him", Toast.LENGTH_SHORT).show()
                    binding.txtOther.visibility = View.GONE
                }
                R.id.gFemale->{
                    Toast.makeText(this,"she/her", Toast.LENGTH_SHORT).show()
                    binding.txtOther.visibility = View.GONE
                }
                R.id.gOther->{
                    binding.txtOther.visibility = View.VISIBLE
                }
                else->{}
            }
        }

        binding.btnSubmit2.setOnClickListener {
            if(binding.terms.isChecked == false){
                Toast.makeText(this,"Please accept the Terms & Conditions.", Toast.LENGTH_SHORT).show()
            }
            else if (binding.enterName.text.toString().isNullOrEmpty()){
                binding.enterName.error = "This field can not be empty"
                binding.enterName.requestFocus()
            }
            else if (binding.enterEmail.text.toString().isNullOrEmpty()){
                binding.enterEmail.error = "This field can not be empty"
                binding.enterEmail.requestFocus()
            }
            else if (binding.enterDOB.text.toString().isNullOrEmpty()){
                binding.enterDOB.error = "This field can not be empty"
                binding.enterDOB.requestFocus()
            }
            else if (binding.enterPhone.text.toString().isNullOrEmpty()){
                binding.enterPhone.error = "This field can not be empty"
                binding.enterPhone.requestFocus()
            }
            else if (binding.enterCity.text.toString().isNullOrEmpty()){
                binding.enterCity.error = "This field can not be empty"
                binding.enterCity.requestFocus()
            }
            else if (binding.enterPin.text.toString().isNullOrEmpty()){
                binding.enterPin.error = "This field can not be empty"
                binding.enterPin.requestFocus()
            }
        }
    }
}