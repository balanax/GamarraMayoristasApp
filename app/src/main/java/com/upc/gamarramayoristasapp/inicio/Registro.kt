package com.upc.gamarramayoristasapp.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.DAO.DbHelper
import com.upc.gamarramayoristasapp.R
import com.upc.gamarramayoristasapp.perfil.RecuperarClave

class Registro : AppCompatActivity() {
    private lateinit var databaseHelper: DbHelper
    private lateinit var editTextName: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        databaseHelper = DbHelper(this)
        editTextName = findViewById(R.id.nombre)
        editTextEmail = findViewById(R.id.correo)
        editTextPassword = findViewById(R.id.contraseña)
        buttonRegister = findViewById(R.id.login)


        buttonRegister.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()


            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                databaseHelper.addUser(name, email, password)
                Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                editTextName.text.clear()
                editTextEmail.text.clear()
                editTextPassword.text.clear()
            } else {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }



    }

}