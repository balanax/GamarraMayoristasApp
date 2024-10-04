package com.upc.gamarramayoristasapp.carrito

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.DireccionDAO
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.CompraFinalizada
import com.upc.gamarramayoristasapp.pago.DireccionEnvio
import com.upc.gamarramayoristasapp.pago.MetodoPago
import com.upc.gamarramayoristasapp.pago.adapter.TarjetaAdapter


class CarritoVerificar() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carrito_verificar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bt_siguiente = findViewById<ImageButton>(R.id.ivRetroceder)
        bt_siguiente.setOnClickListener{
            var intent = Intent(this,Carrito::class.java)
            startActivity(intent)
        }

        val bt_cambiar_direccion = findViewById<TextView>(R.id.tvCambiar)
        bt_cambiar_direccion.setOnClickListener{
            var intent = Intent(this, DireccionEnvio::class.java)
            startActivity(intent)
        }

        val bt_cambiar_tarjeta = findViewById<TextView>(R.id.tvCambiar2)
        bt_cambiar_tarjeta.setOnClickListener{
            var intent = Intent(this, MetodoPago::class.java)
            startActivity(intent)
        }


        val bt_procesarPago = findViewById<Button>(R.id.btProcesarPago)
        bt_procesarPago.setOnClickListener {
            var intent = Intent(this, CompraFinalizada::class.java)
            startActivity(intent)
        }


        val MPdao = MetodoPagoDAO(baseContext)
        val DIRdao = DireccionDAO(baseContext)

        try {
            val rTarjeta = MPdao.TarjetaPredeterminada("1")
            val rDireccion = DIRdao.DireccionPreterminado("1")

            //Tarjeta
            val pTarjeta = findViewById<TextView>(R.id.tvNumTarjeta)
            val pVencimiento = findViewById<TextView>(R.id.tvFechaVencimiento)

            //Direccion
            val pNombre = findViewById<TextView>(R.id.idnombre)
            val pDireccion1 = findViewById<TextView>(R.id.iddireccion1)
            val pDireccion2 = findViewById<TextView>(R.id.iddireccion2)

            pTarjeta.text = rTarjeta.PAN
            pVencimiento.text = rTarjeta.FechaExpiracion

            pNombre.text = rDireccion.Nombre
            pDireccion1.text = rDireccion.Direccion
            pDireccion2.text = rDireccion.Distrito + " - " + rDireccion.Provincia

        } catch (e: DAOException) {
            //Log.i(Tools.LOGTAG, "BuscarActivity ==> " + e.message)
        }

    }




}