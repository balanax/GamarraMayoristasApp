package com.upc.gamarramayoristasapp.carrito

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.adapter.CarritoAdapter
import com.upc.gamarramayoristasapp.favoritos.Favoritos
import com.upc.gamarramayoristasapp.inicio.Inicio
import com.upc.gamarramayoristasapp.perfil.Perfil
import com.upc.gamarramayoristasapp.producto.Categoria

class Carrito : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carrito)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecycleView()

        val btn_siguiente = findViewById<Button>(R.id.btSiguienteCarrito)

        btn_siguiente.setOnClickListener {
            var intent = Intent(this, CarritoVerificar::class.java)
            startActivity(intent)
        }


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.menu_carrito

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_inicio -> {
                    // Acción para Home
                    var intent = Intent(this, Inicio::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_carrito -> {
                    var intent = Intent(this,Carrito::class.java)
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

    }


    private fun initRecycleView(){
        val recycleView = findViewById<RecyclerView>(R.id.recycleCarrito)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = CarritoAdapter(CarritoProvider.CarritoList)
    }
}