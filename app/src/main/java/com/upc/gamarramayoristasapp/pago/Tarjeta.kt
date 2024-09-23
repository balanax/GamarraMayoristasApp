package com.upc.gamarramayoristasapp.pago

data class Tarjeta (
                        val PAN:String,
                        val Nombre:String,
                        val FechaExpiracion:String,
                        val isPredeterminado:Boolean
)