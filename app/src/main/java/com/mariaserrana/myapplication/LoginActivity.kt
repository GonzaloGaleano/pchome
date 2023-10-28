package com.mariaserrana.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.mariaserrana.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnRegistrarse.setOnClickListener {
            val i = Intent(this, RegistrarseActivity::class.java)
            startActivity(i)
        }
        binding.btnIniciarSesion.setOnClickListener {
            val i = Intent(this, InicarSesionActivity::class.java)
            startActivity(i)
        }
    }
}