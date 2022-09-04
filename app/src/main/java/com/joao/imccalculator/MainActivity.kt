package com.joao.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.calcular).setOnClickListener { calculateIMC() }
    }

    private fun calculateIMC() {
        val alturaText = findViewById<EditText>(R.id.altura)
        val pesoText   = findViewById<EditText>(R.id.peso)
        val resultImc  = findViewById<TextView>(R.id.imc)

        val alturaStr = alturaText.text.toString().trim()
        val pesoStr   = pesoText.text.toString().trim()

        if (alturaStr != "" && pesoStr != "" ) {
            val alturaNum = alturaStr.toFloat()
            val pesoNum   = pesoStr.toFloat()

            val imcResult = ( pesoNum / ( alturaNum * alturaNum ) )

            var imcTextAux : String = ""
            if (imcResult <= 18.4){
                imcTextAux =  "Abaixo do peso"
            }
            else if ((imcResult > 18.4) && (imcResult <= 24.9)){
                imcTextAux =  "Peso normal"
            }
            else if ((imcResult > 24.9) && (imcResult <= 29.9)){
                imcTextAux =  "Sobrepeso"
            }
            else if ((imcResult > 29.9) && (imcResult <= 34.9)){
                imcTextAux =  "Obesidade"
            }
            else if(imcResult > 34.9){
                imcTextAux =  "Obesidade Severa"
            }

            val resultString = String.format("%.2f", imcResult) + " - " + imcTextAux
            resultImc.text = resultString
        }
        else {
            resultImc.text = "Preencha os campos altura e peso!"
        }
    }
}