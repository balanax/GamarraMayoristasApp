package com.upc.gamarramayoristasapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import com.upc.gamarramayoristasapp.perfil.OrdenesModel

// Clase que maneja la base de datos
class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "GamarraMayoristasDB2.db"
        private const val DATABASE_VERSION = 1

        // Nombre de la tabla y columnas
        const val TABLE_ORDENES = "ordenes"
        const val COLUMN_ID = "id"
        const val COLUMN_NRORDEN = "nrorden"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_NROTRAKING = "nrotraking"
        const val COLUMN_CANTIDAD = "cantidad"
        const val COLUMN_MONTO = "monto"
        const val COLUMN_ESTADO = "estado"
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Crear la tabla de Órdenes
        val createTable = ("CREATE TABLE $TABLE_ORDENES ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_NRORDEN TEXT, "
                + "$COLUMN_FECHA TEXT, "
                + "$COLUMN_NROTRAKING TEXT, "
                + "$COLUMN_CANTIDAD TEXT, "
                + "$COLUMN_MONTO TEXT, "
                + "$COLUMN_ESTADO TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Borrar tabla existente si se actualiza la versión
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ORDENES")
        onCreate(db)
    }

    // Función para obtener todas las órdenes
    fun getAllOrdenes(): List<OrdenesModel> {
        val ordenList = ArrayList<OrdenesModel>()
        val selectQuery = "SELECT * FROM $TABLE_ORDENES"
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery(selectQuery, null)

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val orden = OrdenesModel(
                        id = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                        nrorden = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NRORDEN)),
                        fecha = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA)),
                        nrotraking = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NROTRAKING)),
                        cantidad = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CANTIDAD)),
                        monto = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MONTO)),
                        estado = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ESTADO))
                    )
                    ordenList.add(orden)
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        return ordenList
    }

    // Función para insertar una nueva orden
    fun insertOrden(orden: OrdenesModel) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NRORDEN, orden.nrorden)
            put(COLUMN_FECHA, orden.fecha)
            put(COLUMN_NROTRAKING, orden.nrotraking)
            put(COLUMN_CANTIDAD, orden.cantidad)
            put(COLUMN_MONTO, orden.monto)
            put(COLUMN_ESTADO, orden.estado)
        }
        db.insert(TABLE_ORDENES, null, values)
    }
}
