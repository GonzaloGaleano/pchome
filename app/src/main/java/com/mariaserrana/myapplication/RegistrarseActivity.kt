package com.mariaserrana.myapplication

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mariaserrana.myapplication.dao.DaoUsuario
import com.mariaserrana.myapplication.dao.Usuario
import com.mariaserrana.myapplication.databinding.ActivityRegistrarseBinding
import com.mariaserrana.myapplication.sql.AdminSQLiteOpenHelper

class RegistrarseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarseBinding
    var dao: DaoUsuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarseBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        dao = DaoUsuario(this)
    }

    fun CANCELAR(view: View?) {
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }

    fun regresar(View: View?) {
        val u = Usuario()
        u.cedula = binding.numCi.text.toString()
        u.nombres = binding.nom.text.toString()
        u.apellidos = binding.ape.text.toString()
        u.celular = binding.celu.text.toString()
        u.usuario = binding.usu.text.toString()
        u.contraseña = binding.contra.text.toString()
        if (!u.isNull) {
            Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_LONG).show()
        } else if (dao?.insertUsuario(u) == true) {
            Toast.makeText(this, "Registro Exitoso!!!", Toast.LENGTH_LONG).show()
            val i2 = Intent(this, InicarSesionActivity::class.java)
            startActivity(i2)
            finish()
        } else {
            Toast.makeText(this, "Usuario ya fue registrado", Toast.LENGTH_LONG).show()
        }
        //     break;
        //     case R.id.can:
        val u1 = Usuario()
        u1.cedula = binding.numCi.text.toString()
        u1.nombres = binding.nom.text.toString()
        u1.apellidos = binding.ape.text.toString()
        u1.celular = binding.celu.text.toString()
        u1.usuario = binding.usu.text.toString()
        u1.contraseña = binding.contra.text.toString()
        if (!u1.isNull) {
            Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_LONG).show()
        } else if (dao?.insertUsuario(u1) == true) {
            Toast.makeText(this, "Actualizado!!!", Toast.LENGTH_LONG).show()
            val i2 = Intent(this, InicarSesionActivity::class.java)
            startActivity(i2)
            finish()
        }
        //       break;
    }

    fun modificar(v: View?) {
        val admin = AdminSQLiteOpenHelper(this, "BDUsuarios", null, 1)
        val bd: SQLiteDatabase = admin.writableDatabase
        val cedula = binding.numCi.text.toString()
        val nombre: String = binding.nom.text.toString()
        val apellido: String = binding.ape.text.toString()
        val celular: String = binding.celu.text.toString()
        val usuario: String = binding.usu.text.toString()
        val contraseña: String = binding.contra.text.toString()
        val registro = ContentValues()
        registro.put("cedula", cedula)
        registro.put("nombres", nombre)
        registro.put("apellidos", apellido)
        registro.put("celular", celular)
        registro.put("usuario", usuario)
        registro.put("contraseña", contraseña)
        val cant = bd.update("usuario", registro, "cedula=$cedula", null)
        bd.close()
        if (cant == 1) Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
            .show() else Toast.makeText(
            this, "no existe un artículo con el código ingresado",
            Toast.LENGTH_SHORT
        ).show()
    }
}