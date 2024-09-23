package com.upc.gamarramayoristasapp.carrito

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.adapter.CarritoAdapter

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
    }

    private fun initRecycleView(){
        val recycleView = findViewById<RecyclerView>(R.id.recycleCarrito)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = CarritoAdapter(CarritoProvider.CarritoList)
    }
}