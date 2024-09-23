package com.upc.gamarramayoristasapp.inicio

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        supportActionBar?.hide()

        setContentView(R.layout.activity_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCarrito = findViewById<Button>(R.id.btnCarrito)

        btnCarrito.setOnClickListener {
            var intent = Intent(this, Carrito::class.java)
            startActivity(intent)
        }
    }



}