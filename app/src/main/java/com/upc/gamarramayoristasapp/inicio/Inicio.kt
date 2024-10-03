package com.upc.gamarramayoristasapp.inicio

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito
import com.upc.gamarramayoristasapp.favoritos.Favoritos
import com.upc.gamarramayoristasapp.perfil.Perfil
import com.upc.gamarramayoristasapp.producto.Categoria
import com.upc.gamarramayoristasapp.producto.DetalleProducto

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

//        val btnCarrito = findViewById<Button>(R.id.btnCarrito)
//
//        btnCarrito.setOnClickListener {
//            var intent = Intent(this, Carrito::class.java)
//            startActivity(intent)
//        }
        //Para mostrar la pantalla de inicio_nuevo
        val verTodo =findViewById<TextView>(R.id.textVertodo)

        verTodo.setOnClickListener {
            var intent = Intent(this, Inicio_Nuevo::class.java)
            startActivity(intent)
        }
        //Al dar click imagen de la pantalla nueva, se muestra la pantalla del detalle del producto
        val imageDetalleProd1 =findViewById<ImageView>(R.id.imageDetalleProd1)
        val imageDetalleProd2 =findViewById<ImageView>(R.id.imageDetalleProd2)

        imageDetalleProd1.setOnClickListener {
            var intent = Intent(this, DetalleProducto::class.java)
            startActivity(intent)
        }
        imageDetalleProd2.setOnClickListener {
            var intent = Intent(this, DetalleProducto::class.java)
            startActivity(intent)
        }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_inicio -> {
                    // Acción para Home
                    var intent = Intent(this,Inicio::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_carrito -> {
                    var intent = Intent(this,Carrito::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_categoria -> {
                    var intent = Intent(this,Categoria::class.java)
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


    }

}