package com.upc.gamarramayoristasapp.pago

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R

class DetalleOrden : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_orden)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nroOrden = intent.getStringExtra("nroOrden")
        val fecha = intent.getStringExtra("fecha")
        val nrotraking = intent.getStringExtra("nrotraking")
        val cantidad = intent.getStringExtra("cantidad")
        val monto = intent.getStringExtra("monto")
        val estado = intent.getStringExtra("estado")

        findViewById<TextView>(R.id.txtNroOrden).text = "Numero de orden : ${nroOrden}"

    }
}