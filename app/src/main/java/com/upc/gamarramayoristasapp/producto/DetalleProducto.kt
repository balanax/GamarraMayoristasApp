package com.upc.gamarramayoristasapp.producto

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R

class DetalleProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_producto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinnerTalla = findViewById<Spinner>(R.id.spinnerTalla)
        // Definir las opciones
        val opcionesTalla = arrayOf("S", "M", "L", "XL")
        // Crear un ArrayAdapter para las opciones del Spinner
        val adapterTalla = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesTalla)
        // Establecer el layout para el menú desplegable
        adapterTalla.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Asignar el adaptador al Spinner
        spinnerTalla.adapter = adapterTalla

        val spinnerColor = findViewById<Spinner>(R.id.spinnerColor)
        val opcionesColor = arrayOf("Rojo", "Negro", "Azul", "Blanco")
        val adapterColor = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesColor)
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerColor.adapter = adapterColor


    }
}