import android.content.Context
import android.database.Cursor

import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.DbHelper
import com.upc.gamarramayoristasapp.Model.ProductoModel


class ProductoDAO(myContext: Context) {

    private var dbHelper: DbHelper = DbHelper(myContext)

    fun BuscarProducto(IdProducto: String): ProductoModel{

        val db = dbHelper.readableDatabase
        var producto = ProductoModel("", "", "", "", "","")
        try {
            val c: Cursor = db.rawQuery(
                "SELECT id_producto, talla, nombre, color, precio, descripcion FROM producto where id_producto ='$IdProducto'",
                null
            )
            if (c.count > 0) {
                c.moveToFirst()
                do {

                    val talla: String = c.getString(c.getColumnIndex("talla"))
                    val nombre: String = c.getString(c.getColumnIndex("nombre"))
                    val color: String = c.getString(c.getColumnIndex("color"))
                    val precio: String = c.getString(c.getColumnIndex("precio"))
                    val descripcion: String = c.getString(c.getColumnIndex("descripcion"))

                    producto = ProductoModel(IdProducto, talla, nombre, color, precio,descripcion)

                } while (c.moveToNext())
            }
            c.close()
        } catch (e: Exception) {
            throw DAOException("ProductoDAO: Error al obtener: " + e.message)
        } finally {
            db.close()
        }
        return producto

    }

}