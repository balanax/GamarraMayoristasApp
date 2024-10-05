package com.upc.gamarramayoristasapp.DAO

import android.content.Context
import android.database.Cursor
import com.upc.gamarramayoristasapp.Model.DireccionModel
import com.upc.gamarramayoristasapp.pago.Direccion
import com.upc.gamarramayoristasapp.pago.Tarjeta

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

    fun ListarDireccion(IdUsuario: String): ArrayList<Direccion>{

        val db = dbHelper.readableDatabase
        val lista = ArrayList<Direccion>()
        try {
            val c: Cursor = db.rawQuery(
                "select id_direccion, id_usuario, nombre, direccion, region, provincia, distrito, codigo_postal, predeterminado from Direccion where id_usuario = $IdUsuario ",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id_direccion_tx:String = c.getString(c.getColumnIndex("id_direccion"))
                    val nombre_tx: String = c.getString(c.getColumnIndex("nombre"))
                    val direccion_tx: String = c.getString(c.getColumnIndex("direccion"))
                    val region_tx: String = c.getString(c.getColumnIndex("region"))
                    val provincia_tx: String = c.getString(c.getColumnIndex("provincia"))
                    val distrito_tx: String = c.getString(c.getColumnIndex("distrito"))
                    val codigo_postal_tx: String = c.getString(c.getColumnIndex("codigo_postal"))
                    val predeterminado: Int = c.getInt(c.getColumnIndex("predeterminado"))

                    val isPredeterminado: Boolean
                    if(predeterminado == 1){
                        isPredeterminado = true
                    }else{
                        isPredeterminado = false
                    }

                    val direccion = Direccion(id_direccion_tx, nombre_tx, direccion_tx, region_tx,distrito_tx, provincia_tx, codigo_postal_tx, isPredeterminado)

                    lista.add(direccion)

                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DireccionDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return lista

    }

    fun AsignarDireccionPredeterminado(id_direccion: String, id_usuario: String): Long{

        val db = dbHelper.writableDatabase
        try {

            db.execSQL("UPDATE Direccion SET predeterminado = 0 WHERE id_usuario =$id_usuario")
            db.execSQL("UPDATE Direccion SET predeterminado = 1 WHERE id_direccion=$id_direccion and id_usuario =$id_usuario")

        } catch (e: Exception) {
            throw DAOException("DireccionDAO: Error al actualizar: " + e.message)
        } finally {
            db.close()
        }

        return 0

    }

    fun DireccionPreterminado(IdUsuario: String): Direccion{

        val db = dbHelper.readableDatabase
        var pDireccion = Direccion("","","","","","","",true)
        try {
            val c: Cursor = db.rawQuery(
                "select id_direccion, id_usuario, nombre, direccion, region, provincia, distrito, codigo_postal, predeterminado from Direccion where predeterminado = 1 and id_usuario = $IdUsuario ",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {
                    val id_direccion_tx:String = c.getString(c.getColumnIndex("id_direccion"))
                    val nombre_tx: String = c.getString(c.getColumnIndex("nombre"))
                    val direccion_tx: String = c.getString(c.getColumnIndex("direccion"))
                    val region_tx: String = c.getString(c.getColumnIndex("region"))
                    val provincia_tx: String = c.getString(c.getColumnIndex("provincia"))
                    val distrito_tx: String = c.getString(c.getColumnIndex("distrito"))
                    val codigo_postal_tx: String = c.getString(c.getColumnIndex("codigo_postal"))
                    val predeterminado: Int = c.getInt(c.getColumnIndex("predeterminado"))

                    val isPredeterminado: Boolean
                    if(predeterminado == 1){
                        isPredeterminado = true
                    }else{
                        isPredeterminado = false
                    }

                    pDireccion = Direccion(id_direccion_tx, nombre_tx, direccion_tx, region_tx,distrito_tx, provincia_tx, codigo_postal_tx, isPredeterminado)


                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("DireccionDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return pDireccion

    }



    fun ObtenerDireccion(): DireccionModel{

        var item = DireccionModel()

        return item

    }

}