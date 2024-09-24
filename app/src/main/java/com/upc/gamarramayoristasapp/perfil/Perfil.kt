package com.upc.gamarramayoristasapp.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.appgamarra.PerfilAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito
import com.upc.gamarramayoristasapp.favoritos.Favoritos
import com.upc.gamarramayoristasapp.inicio.Inicio
import com.upc.gamarramayoristasapp.perfil.OptionPerfil
import com.upc.gamarramayoristasapp.producto.Categoria

class Perfil : AppCompatActivity() {

    private var listaProfile: MutableList<OptionPerfil> = mutableListOf()
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //  val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //  v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //  insets

        listaProfile.add(
            OptionPerfil("Mis Pedidos", "Ya tengo 12 pedidos"))
        listaProfile.add(
            OptionPerfil("Direcciones de envío", "3 direcciones"))
        listaProfile.add(
            OptionPerfil("Métodos de pago", "Visa **34"))
        listaProfile.add(
            OptionPerfil("Códigos promocionales", "Tienes códigos promocionales especiales."))
        listaProfile.add(
            OptionPerfil("Mis reseñas", "Reseñas de 4 artículos"))
        listaProfile.add(
            OptionPerfil("Ajustes", "Notificaciones, contraseña"))

        var tabla = findViewById<RecyclerView>(R.id.tablaProfile)
        recycler=tabla
        recycler.layoutManager=LinearLayoutManager(this)
        recycler.adapter= PerfilAdapter(this, listaProfile)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.menu_perfil

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


    }
}
//}