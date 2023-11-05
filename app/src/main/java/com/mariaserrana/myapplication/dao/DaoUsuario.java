package com.mariaserrana.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DaoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tabla = "create table if not exists usuario(cedula int primary key,nombres text,apellidos text,celular int,usuario text,contraseña text)";

    public DaoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }
    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("cedula", u.getCedula());
            cv.put("nombres", u.getNombres());
            cv.put("apellidos", u.getApellidos());
            cv.put("celular", u.getCelular());
            cv.put("usuario", u.getUsuario());
            cv.put("contraseña", u.getContraseña());
            return (sql.insert("usuario", null, cv) > 0);

        } else {
            return false;
        }
    }
    public int buscar(String u) {
        int x = 0;
        lista = selectUsuario();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }
        }
        return x;
    }
    public ArrayList<Usuario> selectUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Usuario u = new Usuario();
                u.setCedula(cr.getString(0));
                u.setNombres(cr.getString(1));
                u.setApellidos(cr.getString(2));
                u.setDireccion(cr.getString(3));
                u.setCiudad(cr.getString(4));
                u.setTelefono(cr.getString(5));
                u.setCelular(cr.getString(6));

                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }
    public int login(String u, String p) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(7).equals(u) && cr.getString(8).equals(p)) {
                    a++;
                }

            } while (cr.moveToNext());
        }
        return a;
    }
    public Usuario getUsuario(String u, String p) {
        lista = selectUsuario();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u) && us.getContraseña().equals(p)) {
                return us;

            }
        }
        return null;
    }

}
