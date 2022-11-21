package com.example.homework_3_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_3_5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            counter++
            binding.textView.text = counter.toString()
            if (counter == 10) {
                binding.button.text = applicationContext.getString(R.string.minus_1)
                binding.button.setOnClickListener {
                    counter--
                    binding.textView.text = counter.toString()
                    if (counter == 0) {
                        binding.button.setOnClickListener {
                            val intent = Intent(this, NewActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            }
        }
    }
}