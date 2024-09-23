package com.upc.gamarramayoristasapp.carrito

import com.upc.gamarramayoristasapp.producto.DetalleProducto

data class ListCarrito (
    val nombreProducto:String,
    val color:String,
    val detalleColor:String,
    val Talla:String,
    val detalleTalla:String,
    val cantidadProducto: String,
    val precioProducto: String,
    val imagenProducto: String,
) {
}