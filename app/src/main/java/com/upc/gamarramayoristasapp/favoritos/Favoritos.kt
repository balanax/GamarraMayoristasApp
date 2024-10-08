package com.upc.gamarramayoristasapp.favoritos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito
import com.upc.gamarramayoristasapp.inicio.Inicio
import com.upc.gamarramayoristasapp.perfil.Perfil
import com.upc.gamarramayoristasapp.producto.Categoria

class Favoritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favoritos)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_favoritos

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_inicio -> {
                    // Acción para Home
                    var intent = Intent(this, Inicio::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_carrito -> {
                    var intent = Intent(this, Carrito::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_categoria -> {
                    var intent = Intent(this, Categoria::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_favoritos -> {
                    var intent = Intent(this, Favoritos::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_perfil -> {
                    var intent = Intent(this, Perfil::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val btn_Buscar = findViewById<Button>(R.id.btn_Buscar)

        btn_Buscar.setOnClickListener {
            var intent = Intent(this, BuscarActivity::class.java)
            startActivity(intent)
        }



    }
}