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

        listaProfile.add(
            OptionPerfil("Mis Pedidos", "Ya tengo 12 pedidos", PerfilOptionType.MIS_PEDIDOS)
        )
        listaProfile.add(
            OptionPerfil("Direcciones de envío", "3 direcciones", PerfilOptionType.DIRECCIONES_ENVIO)
        )
        listaProfile.add(
            OptionPerfil("Métodos de pago", "Visa **34", PerfilOptionType.METODOS_PAGO)
        )
        listaProfile.add(
            OptionPerfil("Códigos promocionales", "Tienes códigos promocionales especiales.", PerfilOptionType.CODIGOS_PROMOCIONALES)
        )
        listaProfile.add(
            OptionPerfil("Mis reseñas", "Reseñas de 4 artículos", PerfilOptionType.MIS_RESEÑAS)
        )
        listaProfile.add(
            OptionPerfil("Ajustes", "Notificaciones, contraseña", PerfilOptionType.AJUSTES)
        )

        var tabla = findViewById<RecyclerView>(R.id.tablaProfile)
        recycler=tabla
        recycler.layoutManager=LinearLayoutManager(this)

        val adapter = PerfilAdapter(this, listaProfile) { tipo ->
            when (tipo) {
                PerfilOptionType.MIS_PEDIDOS -> {
                    val intent = Intent(this, Ordenes::class.java)
                    startActivity(intent)
                }
                PerfilOptionType.DIRECCIONES_ENVIO -> {
                }
                PerfilOptionType.METODOS_PAGO -> {
                }
                PerfilOptionType.CODIGOS_PROMOCIONALES -> {
                }
                PerfilOptionType.MIS_RESEÑAS -> {
                }
                PerfilOptionType.AJUSTES -> {
                    val intent = Intent(this, ModificarPerfil::class.java)
                    startActivity(intent)
                }
            }
        }

        recycler.adapter= adapter
    }
}
