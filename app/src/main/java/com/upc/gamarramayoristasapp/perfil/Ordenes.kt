package com.upc.gamarramayoristasapp.perfil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.Model.OrdenesModel
import com.upc.gamarramayoristasapp.Model.UsuarioModel
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.database.DatabaseHelper
import com.upc.gamarramayoristasapp.pago.DetalleOrden

class Ordenes : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dbHelper: DatabaseHelper

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

        // Inicializar la base de datos
        dbHelper = DatabaseHelper(this)

//        val nuevoUsuario1 = UsuarioModel("1", "123456", "Paul", "Meza", "40985632", "948020735", "elhughxd@gmail.com","1","1")
//        dbHelper.insertUsuario(nuevoUsuario1)

//        val nuevaOrden2 = OrdenesModel("2", "199377236", "02.10.2024", "IW32684775", "02", "130.20", "Entregado")
//        dbHelper.insertOrden(nuevaOrden2)

        //val nuevaOrden3 = OrdenesModel("3", "192365227", "16.05.2024", "IW32521412", "01", "130.00", "Canceladas")
        //dbHelper.insertOrden(nuevaOrden3)
//
        //val nuevaOrden4 = OrdenesModel("4", "193265897", "10.06.2024", "IW33625425", "01", "70.50", "En Proceso")
        //dbHelper.insertOrden(nuevaOrden4)
//
        //val nuevaOrden5 = OrdenesModel("5", "195214558", "12.06.2024", "IW32125487", "01", "250.00", "En Proceso")
        //dbHelper.insertOrden(nuevaOrden5)
//
        //val nuevaOrden6 = OrdenesModel("6", "198457536", "17.08.2024", "IW33652158", "03", "60.00", "Canceladas")
        //dbHelper.insertOrden(nuevaOrden6)

        // Obtener las órdenes desde la base de datos
        val ordenList = dbHelper.getAllOrdenes()

        // Adaptador para el RecyclerView
        val adapter = OrdenesAdapter(ordenList) { orden ->
            val intent = Intent(this, DetalleOrden::class.java).apply {
                putExtra("nroOrden", orden.nrorden)
                putExtra("fecha", orden.fecha)
                putExtra("nrotraking", orden.nrotraking)
                putExtra("cantidad", orden.cantidad)
                putExtra("monto", orden.monto)
                putExtra("estado", orden.estado)
            }
            startActivity(intent)
        }

        //val ordenList = ArrayList<OrdenesModel>()

        //ordenList.add(OrdenesModel("1","195485236","16.05.2024","IW32654875","02","154.20","Entregado"))
        //ordenList.add(OrdenesModel("2","199377236","16.05.2024","IW32684775","02","130.20","Entregado"))
        //ordenList.add(OrdenesModel("3","192365227","16.05.2024","IW32521412","01","130.00","Canceladas"))
        //ordenList.add(OrdenesModel("4","193265897","10.06.2024","IW33625425","01","70.50","En Proceso"))
        //ordenList.add(OrdenesModel("5","195214558","12.06.2024","IW32125487","01","250.00","En Proceso"))
        //ordenList.add(OrdenesModel("6","198457536","17.08.2024","IW33652158","03","60.00","Canceladas"))

        //val adapter = OrdenesAdapter(ordenList) { orden ->
        //    val intent = Intent(this, DetalleOrden::class.java).apply {
        //        putExtra("nroOrden", orden.nrorden)
        //        putExtra("fecha", orden.fecha)
        //        putExtra("nrotraking", orden.nrotraking)
        //        putExtra("cantidad", orden.cantidad)
        //        putExtra("monto", orden.monto)
        //        putExtra("estado", orden.estado)
        //        //putExtra("direccion", orden.direccion)
        //    }
        //    startActivity(intent)
        //}

        recyclerView.adapter = adapter
    }
}