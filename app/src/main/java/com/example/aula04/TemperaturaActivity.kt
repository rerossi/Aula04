package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.aula04.databinding.ActivityTemperaturaBinding
//import kotlinx.android.synthetic.main.activity_temperatura.*

class TemperaturaActivity : AppCompatActivity() {

     lateinit var binding: ActivityTemperaturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_temperatura)

       /* val editValor: EditText = findViewById(R.id.editValor)
        val grupoTemperatura: RadioGroup = findViewById(R.id.grupoTemperatura)
        val editResultado: EditText = findViewById(R.id.editResultado)
        val buttonConverter: Button = findViewById(R.id.buttonConverter)
       */

        binding.buttonConverter.setOnClickListener {
            if (binding.editValor.text.isNotEmpty()) {
                val valor = binding.editValor.text.toString().toFloat()

                when (binding.grupoTemperatura.checkedRadioButtonId) {
                    R.id.radioKelvin -> {
                        val resultado = valor + 273
                        binding.editResultado.setText(resultado.toString())
                    }

                    R.id.radioFahrenheit -> {
                        val resultado = valor * 9 / 5 + 32
                        binding.editResultado.setText(resultado.toString())
                    }

                    else -> {
                        binding.editResultado.setText("Selecione a temperatura")
                    }
                }
            } else {
                binding.editResultado.setText("Digite um valor de temperatura")
            }
        }
    }
}