package com.upc.gamarramayoristasapp.perfil

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
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.perfil.OptionPerfil

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
    }
}
//}