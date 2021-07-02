package com.kauansantos.gastodeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kauansantos.gastodeviagem.databinding.ActivityMainBinding
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.buttonCalculate.setOnClickListener {
      calculate()
    }
  }

  private fun calculate() {
    if (validationOk()) {
      try {
        val distance = binding.editDistance.text.toString().toFloat()
        val price = binding.editPrice.text.toString().toFloat()
        val autonomy = binding.editAutonomy.text.toString().toFloat()

        val result = (distance * price) / autonomy
        binding.resultValue.text = "R$ ${"%.2f".format(result)}"

      } catch (nfe: NumberFormatException) {
        Toast.makeText(this, getString(R.string.informe_valores_validos), Toast.LENGTH_LONG)
          .show()  //Notificação
      }

    } else {
      Toast.makeText(this, getString(R.string.notificação_campos), Toast.LENGTH_LONG)
        .show()  //Notificação
    }
  }

  private fun validationOk(): Boolean {
    return (binding.editDistance.text.toString() != ""
            && binding.editPrice.text.toString() != ""
            && binding.editAutonomy.text.toString() != ""
            && binding.editAutonomy.text.toString() != "0")

  }
}