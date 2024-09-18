package com.upc.gamarramayoristasapp.perfil

data class Orden(
    val id: String,
    val nrorden: String,
    val fecha: String,
    val nrotraking: String,
    val cantidad: Int,
    val monto: Double,
    val estado: String
)