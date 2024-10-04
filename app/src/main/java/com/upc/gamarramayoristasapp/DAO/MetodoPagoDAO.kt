package com.upc.gamarramayoristasapp.DAO

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.upc.gamarramayoristasapp.Model.MetodoPagoModel
import com.upc.gamarramayoristasapp.pago.Tarjeta

class MetodoPagoDAO(myContext: Context) {
    private var dbHelper: DbHelper = DbHelper(myContext)

    fun InsertarMetodoPago(tarjeta: Tarjeta): Long{

        val indice: Long
        val values = ContentValues().apply {
            put("id_usuario", 1)
            put("nro_tarjeta", tarjeta.PAN)
            put("nombre_cliente", tarjeta.Nombre)
            put("fecha_caducidad", tarjeta.FechaExpiracion)
            put("predeterminado", 0)
        }
        val db = dbHelper.writableDatabase
        try {
            indice = db.insert("Metodo_Pago",null, values)
            return indice
        } catch (e: Exception) {
            throw DAOException("MetodoPagoDAO: Error al insertar: " + e.message)
        } finally {
            db.close()
        }


        return 0
    }

    fun AsignarTarjetaPredeterminado(id_metodo_pago: String, id_usuario: String): Long{

        val db = dbHelper.writableDatabase
        try {
            val args = arrayOf(id_metodo_pago.toString(),id_usuario.toString())

            db.execSQL("UPDATE Metodo_Pago SET predeterminado = 0 WHERE id_usuario =$id_usuario")
            db.execSQL("UPDATE Metodo_Pago SET predeterminado = 1 WHERE id_metodo_pago=$id_metodo_pago and id_usuario =$id_usuario")

        } catch (e: Exception) {
            throw DAOException("MetodoPagoDAO: Error al actualizar: " + e.message)
        } finally {
            db.close()
        }

        return 0

    }


    fun ModificarMetodoPago(): Long{
        return 0
    }

    fun EliminarMetodoPago(): Long{
        return 0
    }

    fun ListarMetodoPago(IdUsuario: String): ArrayList<Tarjeta>{

        val db = dbHelper.readableDatabase
        val lista = ArrayList<Tarjeta>()
        try {
            val c: Cursor = db.rawQuery(
                "select id_metodo_pago, id_usuario, nro_tarjeta, nombre_cliente, fecha_caducidad, predeterminado from Metodo_Pago where id_usuario = $IdUsuario ",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {

                    val id_metodo_pago: String = c.getString(c.getColumnIndex("id_metodo_pago"))
                    val nro_tarjeta: String = c.getString(c.getColumnIndex("nro_tarjeta"))
                    val nombre_cliente: String = c.getString(c.getColumnIndex("nombre_cliente"))
                    val fecha_caducidad: String = c.getString(c.getColumnIndex("fecha_caducidad"))
                    val predeterminado: Int = c.getInt(c.getColumnIndex("predeterminado"))

                    val isPredeterminado: Boolean
                    if(predeterminado == 1){
                        isPredeterminado = true
                    }else{
                        isPredeterminado = false
                    }

                    val metodoPago = Tarjeta(id_metodo_pago, nro_tarjeta, nombre_cliente, fecha_caducidad, isPredeterminado)


                    lista.add(metodoPago)
                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("MetodoPagolDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return lista
    }

    fun TarjetaPredeterminada(IdUsuario: String): Tarjeta{

        val db = dbHelper.readableDatabase
        var pTarjeta = Tarjeta("","","","",true)
        try {
            val c: Cursor = db.rawQuery(
                "select id_metodo_pago, id_usuario, nro_tarjeta, nombre_cliente, fecha_caducidad, predeterminado from Metodo_Pago where predeterminado = 1 and id_usuario = $IdUsuario ",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {

                    val id_metodo_pago: String = c.getString(c.getColumnIndex("id_metodo_pago"))
                    val nro_tarjeta: String = c.getString(c.getColumnIndex("nro_tarjeta"))
                    val nombre_cliente: String = c.getString(c.getColumnIndex("nombre_cliente"))
                    val fecha_caducidad: String = c.getString(c.getColumnIndex("fecha_caducidad"))
                    val predeterminado: Int = c.getInt(c.getColumnIndex("predeterminado"))

                    val isPredeterminado: Boolean
                    if(predeterminado == 1){
                        isPredeterminado = true
                    }else{
                        isPredeterminado = false
                    }

                     pTarjeta = Tarjeta(id_metodo_pago, nro_tarjeta, nombre_cliente, fecha_caducidad, isPredeterminado)


                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("MetodoPagolDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return pTarjeta
    }


    fun ObtenerMetodoPago(): MetodoPagoModel{

        var item = MetodoPagoModel()

        return item

    }

}