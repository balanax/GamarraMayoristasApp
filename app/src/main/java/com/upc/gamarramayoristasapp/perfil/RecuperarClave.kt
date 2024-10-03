package com.upc.gamarramayoristasapp.perfil

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.upc.gamarramayoristasapp.R

class RecuperarClave : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recuperar_clave)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recoverEditText: EditText = findViewById(R.id.recoverEmailEditText)
        val recoverButton: Button = findViewById(R.id.recoverButton)

        recoverButton.setOnClickListener {
            val email = recoverEditText.text.toString().trim()


            if (email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches()
            ) {
                // Lógica para la recuperación de contraseña
                Toast.makeText(this, "Se ha enviado un correo de recuperación", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Por favor ingresa un email válido", Toast.LENGTH_SHORT).show()
            }
    }
    }
}