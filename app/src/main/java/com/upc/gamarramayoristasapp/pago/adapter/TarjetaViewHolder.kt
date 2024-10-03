package com.upc.gamarramayoristasapp.pago.adapter


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.DireccionEnvio
import com.upc.gamarramayoristasapp.pago.MetodoPago
import com.upc.gamarramayoristasapp.pago.Tarjeta

class TarjetaViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val codigo = view.findViewById<TextView>(R.id.tvid_metodo_pago)

    val tarjeta = view.findViewById<TextView>(R.id.tvpan)
    val nombre = view.findViewById<TextView>(R.id.tvnombre)
    val caduda = view.findViewById<TextView>(R.id.tvfecha)
    val imgTarjeta = view.findViewById<ImageView>(R.id.ivtarjeta)

    val activo = view.findViewById<CheckBox>(R.id.chkpredeterminado)

    val imageUri_card_off = Uri.parse("android.resource://" + view.context.packageName + "/" + R.drawable.card_off)
    val imageUri_card_on = Uri.parse("android.resource://" + view.context.packageName + "/" + R.drawable.card_on)


    fun render(tarjetaItem: Tarjeta){
        tarjeta.text = tarjetaItem.PAN
        nombre.text = tarjetaItem.Nombre
        caduda.text = tarjetaItem.FechaExpiracion
        codigo.text = tarjetaItem.id_metodo_pago

        if(tarjetaItem.isPredeterminado){
            activo.isChecked = true
            imgTarjeta.setImageURI(imageUri_card_on)

        }else{
            activo.isChecked = false
            imgTarjeta.setImageURI(imageUri_card_off)
        }

        imgTarjeta.setOnClickListener {
            var intent = Intent(imgTarjeta.context, DireccionEnvio::class.java)
            imgTarjeta.context.startActivity(intent)
            //Toast.makeText(imgTarjeta.context, "Tarjeta: "+ tarjeta.text.toString(), Toast.LENGTH_SHORT).show()

        }

        activo.setOnClickListener{

            val dao = MetodoPagoDAO(activo.context)

            try {
                val indice = dao.AsignarTarjetaPredeterminado(codigo.text.toString(),"1")
            } catch (e: DAOException) {
                //Error al registrar
                Toast.makeText(activo.context,e.message, Toast.LENGTH_SHORT).show()
            }

            var intent = Intent(activo.context, MetodoPago::class.java)
            imgTarjeta.context.startActivity(intent)

        }



    }

}