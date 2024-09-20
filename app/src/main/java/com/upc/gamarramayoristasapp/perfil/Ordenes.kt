package com.upc.gamarramayoristasapp.perfil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.upc.gamarramayoristasapp.R

class Ordenes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ordenes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.rvOrdenes)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val ordenList = ArrayList<OrdenesModel>()

        ordenList.add(OrdenesModel("1","195485236","16.05.2024","IW32654875","02","154.20","Entregado"))
        ordenList.add(OrdenesModel("2","199377236","16.05.2024","IW32684775","02","130.20","Entregado"))
        ordenList.add(OrdenesModel("3","192365227","16.05.2024","IW32521412","01","130.00","Canceladas"))
        ordenList.add(OrdenesModel("4","193265897","10.06.2024","IW33625425","01","70.50","En Proceso"))
        ordenList.add(OrdenesModel("5","195214558","12.06.2024","IW32125487","01","250.00","En Proceso"))
        ordenList.add(OrdenesModel("6","198457536","17.08.2024","IW33652158","03","60.00","Canceladas"))

        val adapter = OrdenesAdapter(ordenList)

        recyclerView.adapter = adapter
    }
}