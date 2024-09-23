package com.upc.gamarramayoristasapp.DAO

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(myContext: Context): SQLiteOpenHelper(myContext,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "GamarraMayoristasDB.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE Metodo_Pago (id_metodo_pago  INTEGER PRIMARY KEY ASC , id_usuario INTEGER, nro_tarjeta nvarchar(50), nombre_cliente nvarchar(50), fecha_caducidad nvarchar(50), predeterminado INTEGER)"
        db.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Metodo_Pago")
        onCreate(db)

    }

}