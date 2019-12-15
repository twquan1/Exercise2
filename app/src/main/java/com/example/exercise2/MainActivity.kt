package com.example.exercise2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.exercise2.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonCalculate.setOnClickListener{
            val BMI = binding.editTextWeight.text.toString().toDouble()/ (binding.editTextHeight.text.toString().toDouble() / 100).pow(2.0)
            binding.textViewBMI.text = "BMI : " + BMI.toString()

            if(BMI < 18.5){
                binding.imageViewProfile.setImageResource(R.drawable.under)
            }else if (BMI in 18.5..24.9){
                binding.imageViewProfile.setImageResource(R.drawable.normal)
            }else{
                binding.imageViewProfile.setImageResource(R.drawable.over)
            }
        }

        binding.buttonReset.setOnClickListener{
            binding.imageViewProfile.setImageResource(R.drawable.empty)
            binding.textViewBMI.text = "BMI : "
            binding.editTextWeight.setText("")
            binding.editTextHeight.setText("")
        }
    }
}
