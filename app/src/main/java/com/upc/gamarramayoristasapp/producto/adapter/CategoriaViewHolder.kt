package com.upc.gamarramayoristasapp.producto.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.producto.ListCategoria

class CategoriaViewHolder (view: View): RecyclerView.ViewHolder(view){
    val nombreCategoria = view.findViewById<TextView>(R.id.tvNombreCategoria)
    val imagenCategoria = view.findViewById<ImageView>(R.id.ivImagenCategoria)

    fun render (categoriaModel: ListCategoria){
        nombreCategoria.text = categoriaModel.nombreCategoria
        Glide.with(imagenCategoria.context).load(categoriaModel.imagenCategoria).into(imagenCategoria)
    }

}