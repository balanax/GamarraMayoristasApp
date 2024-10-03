package com.upc.gamarramayoristasapp.pago.adapter

import android.content.Intent
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.DireccionDAO
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.pago.CompraFinalizada
import com.upc.gamarramayoristasapp.pago.Direccion
import com.upc.gamarramayoristasapp.pago.DireccionEnvio
import com.upc.gamarramayoristasapp.pago.MetodoPago
import com.upc.gamarramayoristasapp.producto.Categoria


class DireccionViewHolder(view: View): RecyclerView.ViewHolder(view)  {

    val nombre = view.findViewById<TextView>(R.id.tvNombre_dir)
    val direccion1 = view.findViewById<TextView>(R.id.tvDireccion1_dir)
    val direccion2 = view.findViewById<TextView>(R.id.tvDireccion2_dir)
    val imgBotonDireccion = view.findViewById<ImageView>(R.id.ivbotonDireccion)
    val codigo = view.findViewById<TextView>(R.id.tvid_direccion)

    val activo = view.findViewById<CheckBox>(R.id.chkpredeterminado_dir)


    fun render(DireccionItem: Direccion){

        codigo.text = DireccionItem.idDireccion

        nombre.text = DireccionItem.Nombre
        direccion1.text = DireccionItem.Direccion
        direccion2.text = DireccionItem.Region + DireccionItem.Provincia + DireccionItem.Distrito

        if(DireccionItem.isPredeterminado){
            activo.isChecked = true

        }else{
            activo.isChecked = false
        }

        imgBotonDireccion.setOnClickListener {
            var intent = Intent(imgBotonDireccion.context, CompraFinalizada::class.java)
            imgBotonDireccion.context.startActivity(intent)
        }

        activo.setOnClickListener{

            val dao = DireccionDAO(activo.context)

            try {
                val indice = dao.AsignarDireccionPredeterminado(codigo.text.toString(),"1")
            } catch (e: DAOException) {
                //Error al registrar
                Toast.makeText(activo.context,e.message, Toast.LENGTH_SHORT).show()
            }

            var intent = Intent(activo.context, DireccionEnvio::class.java)
            activo.context.startActivity(intent)

        }


    }

}