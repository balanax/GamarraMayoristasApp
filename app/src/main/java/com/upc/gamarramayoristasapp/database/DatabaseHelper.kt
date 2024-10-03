package com.upc.gamarramayoristasapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import com.upc.gamarramayoristasapp.Model.OrdenesModel
import com.upc.gamarramayoristasapp.Model.UsuarioModel

// Clase que maneja la base de datos
class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "GamarraMayoristasDB2.db"
        private const val DATABASE_VERSION = 1

        // Nombre de la tabla y columnas
        const val TABLE_USUARIO = "usuario"
        const val TABLE_ORDENES = "ordenes"
        const val TABLE_ORDENESDETALLE = "detalleorden"

        // Nombre de Columnas para la tabla Usuario
        const val COLUMN_ID_USUARIO = "id_usuario"
        const val COLUMN_CLAVE = "clave"
        const val COLUMN_NOMBRES = "nombres"
        const val COLUMN_APELLIDOS = "apellidos"
        const val COLUMN_DNI = "dni"
        const val COLUMN_TELEFONO = "telefono"
        const val COLUMN_CORREO = "correo"
        const val COLUMN_HABILITADO = "habilitado"
        const val COLUMN_LOGIN = "login"

        // Nombre de Columnas para la tabla Ordenes
        const val COLUMN_ID_ORDEN = "id"
        const val COLUMN_NRORDEN = "nrorden"
        const val COLUMN_FECHA = "fecha"
        const val COLUMN_NROTRAKING = "nrotraking"
        const val COLUMN_CANTIDAD = "cantidad"
        const val COLUMN_MONTO = "monto"
        const val COLUMN_ESTADO = "estado"

    }

    fun CreateTable_usuario(db: SQLiteDatabase){
        val createTable = ("CREATE TABLE $TABLE_USUARIO ("
                + "$COLUMN_ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_CLAVE TEXT, "
                + "$COLUMN_NOMBRES TEXT, "
                + "$COLUMN_APELLIDOS TEXT, "
                + "$COLUMN_DNI TEXT, "
                + "$COLUMN_TELEFONO TEXT, "
                + "$COLUMN_CORREO TEXT, "
                + "$COLUMN_HABILITADO TEXT, "
                + "$COLUMN_LOGIN TEXT)"
                )
        db.execSQL(createTable)
    }

    fun CreateTable_ordenes(db: SQLiteDatabase){
        val createTable = ("CREATE TABLE $TABLE_ORDENES ("
                + "$COLUMN_ID_ORDEN INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_NRORDEN TEXT, "
                + "$COLUMN_FECHA TEXT, "
                + "$COLUMN_NROTRAKING TEXT, "
                + "$COLUMN_CANTIDAD TEXT, "
                + "$COLUMN_MONTO TEXT, "
                + "$COLUMN_ESTADO TEXT)")
        db.execSQL(createTable)
    }

    // Crear la tablas
    override fun onCreate(db: SQLiteDatabase) {
        CreateTable_ordenes(db);
        CreateTable_usuario(db);
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
                        id = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID_ORDEN)),
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

    fun getInfoUsuarioById(id_usuario: String): UsuarioModel? {
        val selectQuery = "SELECT * FROM $TABLE_USUARIO WHERE $COLUMN_ID_USUARIO = ?"
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery(selectQuery, arrayOf(id_usuario))

        var usuario: UsuarioModel? = null

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                usuario = UsuarioModel(
                    id_usuario = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID_USUARIO)),
                    clave = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLAVE)),
                    nombres = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRES)),
                    apellidos = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APELLIDOS)),
                    dni = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DNI)),
                    telefono = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO)),
                    correo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CORREO)),
                    habilitado = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_HABILITADO)),
                    login = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOGIN))
                )
            }
            cursor.close()
        }

        db.close() // Cerramos la base de datos
        return usuario
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

    // Función para insertar un nuevo usuario
    fun insertUsuario(usuario: UsuarioModel) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_CLAVE, usuario.clave)
            put(COLUMN_NOMBRES, usuario.nombres)
            put(COLUMN_APELLIDOS, usuario.apellidos)
            put(COLUMN_DNI  , usuario.dni)
            put(COLUMN_TELEFONO, usuario.telefono)
            put(COLUMN_CORREO, usuario.correo)
            put(COLUMN_HABILITADO, usuario.habilitado)
            put(COLUMN_LOGIN, usuario.login)
        }
        db.insert(TABLE_USUARIO, null, values)
    }
}
