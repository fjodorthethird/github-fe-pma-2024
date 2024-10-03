package com.example.myapp004objednavka

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp004objednavka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var selectedDeskName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroupDesks.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio_hockey -> {
                    binding.imageDesk.setImageResource(R.mipmap.hockey)
                    selectedDeskName = binding.radioHockey.text.toString()
                }
                R.id.radio_sour_solution -> {
                    binding.imageDesk.setImageResource(R.mipmap.sour)
                    selectedDeskName = binding.radioSourSolution.text.toString()
                }
                R.id.radio_palace -> {
                    binding.imageDesk.setImageResource(R.mipmap.palace)
                    selectedDeskName = binding.radioPalace.text.toString()
                }
            }
        }

        binding.buttonOrderDesk.setOnClickListener {
            val summary = buildOrderSummary()
            binding.orderSummary.text = summary
        }
    }

    private fun buildOrderSummary(): String {
        val selectedOptions = mutableListOf<String>()

        if (binding.checkboxBigSize.isChecked) {
            selectedOptions.add("Big size")
        }
        if (binding.checkboxDeepConcave.isChecked) {
            selectedOptions.add("Deep concave")
        }
        if (binding.checkboxCarbonFiber.isChecked) {
            selectedOptions.add("Carbon fiber layer")
        }

        return if (selectedOptions.isNotEmpty()) {
            selectedDeskName + ": " + selectedOptions.joinToString(", ")
        } else {
            "Žádné doplňky nejsou vybrány."
        }
    }
}