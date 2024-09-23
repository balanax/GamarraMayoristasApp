package com.upc.gamarramayoristasapp.pago.adapter


import android.net.Uri
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.Tarjeta

class TarjetaViewHolder (view: View): RecyclerView.ViewHolder(view) {

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

        if(tarjetaItem.isPredeterminado){
            activo.isChecked = true
            imgTarjeta.setImageURI(imageUri_card_on)

        }else{
            activo.isChecked = false
            imgTarjeta.setImageURI(imageUri_card_off)
        }









    }

}