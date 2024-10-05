package com.upc.gamarramayoristasapp.pago

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito
import com.upc.gamarramayoristasapp.carrito.CarritoVerificar
import com.upc.gamarramayoristasapp.pago.adapter.TarjetaAdapter
import com.upc.gamarramayoristasapp.pago.adapter.TarjetaViewHolder

class MetodoPago : AppCompatActivity() {

    lateinit var resultados : ArrayList<Tarjeta>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_metodo_pago)

        initRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fab: FloatingActionButton = findViewById(R.id.btnNuevaTarjeta)
        fab.setOnClickListener {
            // Acción al hacer clic en el FAB
            //Toast.makeText(this, "FAB clickeado", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, NuevaTarjeta::class.java)
            startActivity(intent)
        }

        val btn_regresar_carrito = findViewById<Button>(R.id.button)
        btn_regresar_carrito.setOnClickListener{
            var intent = Intent(this, CarritoVerificar::class.java)
            startActivity(intent)
        }

    }


    private fun initRecyclerView(){

        val dao = MetodoPagoDAO(baseContext)
        try {
            resultados = dao.ListarMetodoPago("1")

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerTarjetas)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = TarjetaAdapter(resultados)

        } catch (e: DAOException) {
            //Log.i(Tools.LOGTAG, "BuscarActivity ==> " + e.message)
        }
    }


}