package com.upc.gamarramayoristasapp.DAO

import android.content.Context
import com.upc.gamarramayoristasapp.Model.DireccionModel

class DireccionDAO(myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun InsertarDireccion(): Long{
        return 0
    }

    fun ModificarDireccion(): Long{
        return 0
    }

    fun EliminarDireccion(): Long{
        return 0
    }

    fun ListarDireccion(): ArrayList<DireccionModel>{

        var lista = ArrayList<DireccionModel>()

        return lista

    }

    fun ObtenerDireccion(): DireccionModel{

        var item = DireccionModel()

        return item

    }

}