package com.example.swetofor

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import com.example.swetofor.databinding.ActivityMainBinding
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentLight = 1 // 0 - красный, 1 - желтый, 2 - зеленый

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Используем ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Установка начальных цветов
        setInitialColors()

        // Обработчик нажатия на кнопку "Start"
        binding.button4.setOnClickListener {
            changeLight()
        }
    }

    private fun setInitialColors() {
        binding.button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
        binding.button2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Желтый
        binding.button3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
        currentLight = 3
    }

    private fun changeLight() {
        when (currentLight) {
            0 -> {
                binding.button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
                binding.button2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark)) // Серый
                binding.button3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Зеленый
                currentLight = 1
            }
            1 -> { // Зеленый сигнал
                binding.button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
                binding.button2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Желтый
                binding.button3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark)) // Серый
                currentLight = 2
            }
            2 -> {
            binding.button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
            binding.button2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark)) // Серый
            binding.button3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Зеленый
            currentLight = 3
            }
            3 -> {
                binding.button.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark)) // Красный
                binding.button2.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
                binding.button3.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray)) // Серый
                currentLight = 0
            }
        }
    }

    /**
     * Сохраняет состояние текущего светофора при повороте устройства
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentLight", currentLight)
    }

    /**
     * Восстанавливает состояние текущего светофора после поворота устройства
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentLight = savedInstanceState.getInt("currentLight")
        setInitialColors() // Перезапускаем начальные цвета
    }
}