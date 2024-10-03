package com.upc.gamarramayoristasapp.favoritos

import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.privacysandbox.tools.core.model.Method
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.Carrito
import com.upc.gamarramayoristasapp.inicio.Inicio
import com.upc.gamarramayoristasapp.perfil.Perfil
import com.upc.gamarramayoristasapp.producto.Categoria
import org.json.JSONException

class BuscarActivity : AppCompatActivity() {
    //lateinit var resultados : ArrayList<ProductoFavoritos>
    //lateinit var listaResultados : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        //val btn100 = findViewById<Button>(R.id.btn_Obtener)

        //btn100.setOnClickListener {
        //  buscar()
        //}

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

    }

    fun buscar(view: View) {

        val txtCriterio = findViewById<View>(R.id.txtCriterio) as EditText
        val criterio = txtCriterio.text.toString().toString()
        val url = "https://ekxqk4uyj8.execute-api.sa-east-1.amazonaws.com/ETEPA1/categoria?nm_categoria=$criterio"

        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val jsonArray = response.getJSONArray("data")
                    Log.i("======>", jsonArray.toString())
                    val items = mutableListOf<String>()
                    for (i in 0 until jsonArray.length()) {
                        val producto = jsonArray.getJSONObject(i)
                        items.add("${producto.getString("nombre")} - ${producto.getString("descripcion")} - ${producto.getString("precio")} - S/. ${producto.getString("stock")}")
                    }

                    val lstProductos = findViewById<ListView>(R.id.lista)
                    val adaptador = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        items
                    )
                    lstProductos.adapter = adaptador

                } catch (e: JSONException) {
                    Log.i("======>", "Error:")
                    Log.i("======>", e.message.toString())
                }
            },
            { error ->
                Log.i("======>", error.toString())
            }
        )
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)

    }
}