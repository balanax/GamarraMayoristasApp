package com.upc.gamarramayoristasapp.pago

class TarjetaProvider {

    companion object {

        val listaTarjetas = listOf<Tarjeta>(
            Tarjeta("5254 **** **** 1234","Danny Herrera","09/28",true),
            Tarjeta("5254 **** **** 5678","Danny Herrera","10/29",false),
            Tarjeta("5254 **** **** 9012","Danny Herrera","11/30",false)
        )
    }


}