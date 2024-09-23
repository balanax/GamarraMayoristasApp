package com.upc.gamarramayoristasapp.DAO

import android.content.Context
import com.upc.gamarramayoristasapp.Model.MetodoPagoModel

class MetodoPagoDAO(myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun InsertarMetodoPago(): Long{
        return 0
    }

    fun ModificarMetodoPago(): Long{
        return 0
    }

    fun EliminarMetodoPago(): Long{
        return 0
    }

    fun ListarMetodoPago(): ArrayList<MetodoPagoModel>{

        var lista = ArrayList<MetodoPagoModel>()

        return lista

    }

    fun ObtenerMetodoPago(): MetodoPagoModel{

        var item = MetodoPagoModel()

        return item

    }

}