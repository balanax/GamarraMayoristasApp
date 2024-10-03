package com.upc.gamarramayoristasapp.DAO

import android.content.ContentValues
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
        val createUserTable = """CREATE TABLE TABLA_USERS (id_user INTEGER  PRIMARY KEY AUTOINCREMENT, name NVARCHAR(50), email NVARCHAR(100), password NVARCHAR(50))
    """.trimIndent()
        db.execSQL(createUserTable)

        val createProductos = """CREATE TABLE Tabla_productos (id_productos INTEGER PRIMARY KEY AUTOINCREMENT, nombre_productos NVARCHAR(50), precio_producto REAL NOT NULL, cantidad INTEGER)
    """.trimIndent()
        db.execSQL(createProductos)


    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Metodo_Pago")
        db.execSQL("DROP TABLE IF EXISTS TABLE_USERS")
        db.execSQL("DROP TABLE IF EXISTS Tabla_productos")
        onCreate(db)

    }
    // Método para agregar un usuario
    fun addUser(name: String, email: String, password: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(name, name)
        values.put(email, email)
        values.put(password, password)
        db.insert("TABLA_USERS", null, values)
        db.close()
    }

    // Método para obtener todos los usuarios
    fun getAllUsers(): List<String> {
        val userList = mutableListOf<String>()
        /*        val db = this.readableDatabase
                val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_USERS", null)

                if (cursor.moveToFirst()) {
                    do {
                        val user = cursor.getString(cursor.getColumnIndex(COLUMN_NAME)) // Obtiene el nombre
                        userList.add(user) // Agrega el nombre a la lista
                    } while (cursor.moveToNext())
                }
                cursor.close() // Cierra el cursor
                db.close() // Cierra la base de datos*/
        return userList // Retorna la lista de usuarios
    }

    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM TABLE_USERS WHERE email = ? AND password= ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))

        val isValid = cursor.count > 0
        cursor.close()
        db.close()
        return isValid // Retorna verdadero si el usuario existe, falso si no
    }
}