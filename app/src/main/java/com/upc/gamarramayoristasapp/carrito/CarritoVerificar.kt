package com.upc.gamarramayoristasapp.carrito

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.DireccionEnvio


class CarritoVerificar() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carrito_verificar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bt_siguiente = findViewById<ImageButton>(R.id.ivRetroceder)
        bt_siguiente.setOnClickListener{
            var intent = Intent(this,Carrito::class.java)
            startActivity(intent)
        }

        val bt_cambiar = findViewById<TextView>(R.id.tvCambiar)
        bt_cambiar.setOnClickListener{
            var intent = Intent(this, DireccionEnvio::class.java)
            startActivity(intent)
        }



    }

}