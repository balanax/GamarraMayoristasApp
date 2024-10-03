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
import com.upc.gamarramayoristasapp.perfil.Perfil
import com.upc.gamarramayoristasapp.perfil.RecuperarClave

class Acceso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_acceso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val emailEditText: EditText =findViewById(R.id.emailEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)
        val forgotPasswordTextView: TextView =findViewById(R.id.forgotPasswordTextView)

        var databaseHelper = DbHelper(this) // Inicializa el ayudante de base de datos

    loginButton.setOnClickListener {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        val isValid = databaseHelper.checkUser(email, password) // Verifica las credenciales

        if(isValid){
            Toast.makeText(this@Acceso, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this@Acceso, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }

    }
    forgotPasswordTextView.setOnClickListener {
        val intent = Intent(this, RecuperarClave::class.java)
        startActivity(intent)
    }

}

private fun validateLogin(email: String, password: String): Boolean {
    return email.isNotEmpty() && password.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

}
}