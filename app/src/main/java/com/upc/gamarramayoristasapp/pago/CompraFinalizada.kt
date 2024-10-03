package com.upc.gamarramayoristasapp.pago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.inicio.Inicio

class CompraFinalizada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_compra_finalizada)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_Cotinuar = findViewById<Button>(R.id.btnContinuarComprando)
        btn_Cotinuar.setOnClickListener {
            var intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

    }
}