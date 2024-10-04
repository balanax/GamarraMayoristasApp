package com.upc.gamarramayoristasapp.pago

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.DAO.DAOException
import com.upc.gamarramayoristasapp.DAO.MetodoPagoDAO
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.carrito.CarritoVerificar
import java.util.Calendar

class NuevaTarjeta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nueva_tarjeta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextCreditCard = findViewById<EditText>(R.id.etTarjeta)
        val editTextExpiryDate = findViewById<EditText>(R.id.etFechaExpiracion)
        val expiryDate = editTextExpiryDate.text.toString()

        val btn_Grabar = findViewById<Button>(R.id.btnRegistrarTarjeta)
        btn_Grabar.setOnClickListener {

//            val creditCardNumber = editTextCreditCard.text.toString()
//            if (isValidCreditCardNumber(creditCardNumber) && isValidExpiryDate(expiryDate)) {
//                // Número de tarjeta válido
//                grabar()
//                var intent = Intent(this, MetodoPago::class.java)
//                startActivity(intent)
//
//            } else {
//                // Mostrar mensaje de error
//                Toast.makeText(this, "Datos Incompletos o Incorrectos", Toast.LENGTH_SHORT).show()
//            }
                grabar()
                var intent = Intent(this, CarritoVerificar::class.java)
                startActivity(intent)

        }

        val btn_regresar = findViewById<Button>(R.id.btnRegresar)

        btn_regresar.setOnClickListener{
            var intent = Intent(this, CarritoVerificar::class.java)
            startActivity(intent)
        }

        //Formatea el editText para aceptar numero de tarjetas
        editTextCreditCard.addTextChangedListener(object : TextWatcher {
            private var isUpdating = false
            private val space = ' '

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isUpdating) {
                    return
                }

                isUpdating = true

                // Remover los espacios antiguos
                val input = s.toString().replace(" ", "")
                val formatted = StringBuilder()

                // Añadir espacios cada 4 dígitos
                for (i in input.indices) {
                    if (i > 0 && i % 4 == 0) {
                        formatted.append(space)
                    }
                    formatted.append(input[i])
                }

                // Actualizar el texto en el EditText
                editTextCreditCard.setText(formatted.toString())
                editTextCreditCard.setSelection(formatted.length)

                isUpdating = false
            }
        })



        editTextExpiryDate.addTextChangedListener(object : TextWatcher {
            private var isUpdating = false
            private val slash = '/'

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (isUpdating) {
                    return
                }

                isUpdating = true

                // Eliminar caracteres no numéricos
                val input = s.toString().replace("[^\\d]".toRegex(), "")
                val formatted = StringBuilder()

                // Formatear en MM/AA
                for (i in input.indices) {
                    if (i == 2) {
                        formatted.append(slash)
                    }
                    formatted.append(input[i])
                }

                // Limitar a 5 caracteres (MM/AA)
                if (formatted.length > 5) {
                    formatted.delete(5, formatted.length)
                }

                // Actualizar el campo de texto con el formato
                editTextExpiryDate.setText(formatted.toString())
                editTextExpiryDate.setSelection(formatted.length)

                isUpdating = false
            }
        })

    }

//    fun isValidExpiryDate(date: String): Boolean {
//        if (date.length != 5) return false
//
//        val parts = date.split("/")
//        val month = parts[0].toIntOrNull() ?: return false
//        val year = parts[1].toIntOrNull() ?: return false
//
//        // Verificar que el mes esté entre 1 y 12
//        if (month < 1 || month > 12) return false
//
//        // Obtener el año actual y hacer una validación básica del año de la tarjeta
//        val currentYear = (Calendar.getInstance().get(Calendar.YEAR) % 100)
//
//        return  >= currentYear
//    }

    //Validar el numero de tarjeta
//    fun isValidCreditCardNumber(number: String): Boolean {
//        // Eliminar los espacios
//        val cleanedNumber = number.replace(" ", "")
//
//        // Verificar que tenga 16 dígitos
//        return cleanedNumber.length == 16
//    }

    private fun grabar() {
        val strNombre = findViewById<EditText>(R.id.etNombre)
        val strTarjeta = findViewById<EditText>(R.id.etTarjeta)
        val strFechaCaducidad = findViewById<EditText>(R.id.etFechaExpiracion)

        val dao = MetodoPagoDAO(baseContext)

        val tarjeta = Tarjeta("0",strTarjeta.text.toString(), strNombre.text.toString(), strFechaCaducidad.text.toString(),false)

        try {
            val indice = dao.InsertarMetodoPago(tarjeta)
            if(indice > 0){
                strNombre.setText("")
                strTarjeta.setText("")
                strFechaCaducidad.setText("")
                Toast.makeText(baseContext, "Tarjeta registrada", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(baseContext, "Error al registrar tarjeta", Toast.LENGTH_SHORT).show()
            }

        } catch (e: DAOException) {
            //Error al registrar
            Toast.makeText(baseContext,e.message, Toast.LENGTH_SHORT).show()
        }

    }

}