package com.upc.gamarramayoristasapp.carrito.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.ListCarrito

class CarritoViewHolder (view:View):RecyclerView.ViewHolder(view){

    val nombreProducto = view.findViewById<TextView>(R.id.tvNombreProducto)
    val color = view.findViewById<TextView>(R.id.tvColorProducto)
    val detalleColor = view.findViewById<TextView>(R.id.tvDetalleColorProducto)
    val detalleTalla = view.findViewById<TextView>(R.id.tvDetalleTallaProducto)
    val talla   = view.findViewById<TextView>(R.id.tvTallaProducto)
    val cantidadProducto = view.findViewById<TextView>(R.id.tvCantidadProducto)
    val precioProducto = view.findViewById<TextView>(R.id.tvPrecioProducto)
    val photoCard = view.findViewById<ImageView>(R.id.ivCardCarrito)

    fun render (carritoModel: ListCarrito){
        nombreProducto.text = carritoModel.nombreProducto
        color.text = carritoModel.color
        detalleColor.text = carritoModel.detalleColor
        talla.text = carritoModel.Talla
        detalleTalla.text = carritoModel.detalleTalla
        cantidadProducto.text = carritoModel.cantidadProducto
        precioProducto.text = carritoModel.precioProducto
        Glide.with(photoCard.context).load(carritoModel.imagenProducto).into(photoCard)
    }
}