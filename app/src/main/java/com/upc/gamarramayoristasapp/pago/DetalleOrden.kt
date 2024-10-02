package com.upc.gamarramayoristasapp.pago

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R

class DetalleOrden : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_orden)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el botón "Atrás" en la UI
        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed() // Controla el comportamiento de "Atrás"
        }

        // Configurar OnBackPressedCallback
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Aquí puedes personalizar el comportamiento del botón "Atrás"
                finish() // Cierra la actividad actual
            }
        })

        //recyclerView = findViewById(R.id.rvDetalleOrdenes)

        //recyclerView.layoutManager = LinearLayoutManager(this)

        val nroOrden = intent.getStringExtra("nroOrden")
        val fecha = intent.getStringExtra("fecha")
        val nrotraking = intent.getStringExtra("nrotraking")
        val cantidad = intent.getStringExtra("cantidad")
        val monto = intent.getStringExtra("monto")
        val estado = intent.getStringExtra("estado")

        findViewById<TextView>(R.id.txtNroOrden).text = "Numero de orden : ${nroOrden}"
        findViewById<TextView>(R.id.txtFecha).text = "${fecha}"
        findViewById<TextView>(R.id.txtTraking).text = "Nro. Traking: ${nrotraking}"
        findViewById<TextView>(R.id.txtEstado).text = "${estado}"
        findViewById<TextView>(R.id.txtCantidad).text = "${cantidad} items"

    }
}