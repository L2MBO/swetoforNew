package com.example.swetofor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.swetofor.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentLight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setInitialColors()

        binding.startButton.setOnClickListener {
            changeLight()
        }
    }

    private fun setInitialColors() {
        binding.red.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
        binding.yellow.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Желтый
        binding.green.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
        currentLight = 3
    }

    private fun changeLight() {
        when (currentLight) {
            0 -> {
                binding.red.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                binding.yellow.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark))
                binding.green.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                currentLight = 1
            }
            1 -> {
                binding.red.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                binding.yellow.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                binding.green.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
                currentLight = 2
            }
            2 -> {
                binding.red.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                binding.yellow.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark))
                binding.green.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                currentLight = 3
            }
            3 -> {
                binding.red.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                binding.yellow.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                binding.green.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
                currentLight = 0
            }
        }
    }

    //Сохраняет состояние при повороте
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentLight", currentLight)
    }

    //Восстанавливает состояние после поворота
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentLight = savedInstanceState.getInt("currentLight")
        setInitialColors()
    }
}