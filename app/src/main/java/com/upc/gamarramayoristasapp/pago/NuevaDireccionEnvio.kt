package com.upc.gamarramayoristasapp.pago

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R

class NuevaDireccionEnvio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nueva_direccion_envio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Boton para regresar a la Opcion de Direcciones
        val btn_regresar = findViewById<Button>(R.id.btnRegresar)
        btn_regresar.setOnClickListener{
            var intent = Intent(this, DireccionEnvio::class.java)
            startActivity(intent)
        }

        //Boton para registrar la nueva direccion y regresar a la opcion Direcciones
        val btn_Grabar = findViewById<Button>(R.id.btnRegistrarDireccion)
        btn_Grabar.setOnClickListener {
            //grabar()
            var intent = Intent(this, DireccionEnvio::class.java)
            startActivity(intent)
        }


    }

}