package com.upc.gamarramayoristasapp.pago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.DireccionDAO
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.CarritoVerificar
import com.upc.gamarramayoristasapp.pago.adapter.DireccionAdapter
import com.upc.gamarramayoristasapp.pago.adapter.TarjetaAdapter

class DireccionEnvio : AppCompatActivity() {

    lateinit var resultados : ArrayList<Direccion>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_direccion_envio)

        initRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton para regresar a la Opcion de Metodos de Pago
        val btn_regresar = findViewById<Button>(R.id.btnRegresar)
        btn_regresar.setOnClickListener{
            var intent = Intent(this, CarritoVerificar::class.java)
            startActivity(intent)
        }

        //Boton para ir a la opcion de Nueva Direccion
        val btn_nueva_direccion: FloatingActionButton = findViewById(R.id.btnNuevaDireccion)
        btn_nueva_direccion.setOnClickListener {
            // Acción al hacer clic en el FAB
            //Toast.makeText(this, "FAB clickeado", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, NuevaDireccionEnvio::class.java)
            startActivity(intent)
        }

    }

    private fun initRecyclerView(){

        val dao = DireccionDAO(baseContext)
        try {
            resultados = dao.ListarDireccion("1")

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerDirecciones)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = DireccionAdapter(resultados)

        } catch (e: DAOException) {
            //Log.i(Tools.LOGTAG, "BuscarActivity ==> " + e.message)
        }
    }


}