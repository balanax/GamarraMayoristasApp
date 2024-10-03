package com.upc.gamarramayoristasapp.pago

data class Tarjeta (
                        val id_metodo_pago: String,
                        val PAN:String,
                        val Nombre:String,
                        val FechaExpiracion:String,
                        val isPredeterminado:Boolean
)