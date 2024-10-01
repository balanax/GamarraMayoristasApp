package com.upc.gamarramayoristasapp.pago

data class Direccion  (
                            val idDireccion:String,
                            val Nombre:String,
                            val Direccion:String,
                            val Region:String,
                            val Distrito:String,
                            val Provincia:String,
                            val CodigoPostal:String,
                            val isPredeterminado:Boolean
                        )                    {
}