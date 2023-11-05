package com.mariaserrana.myapplication.dao;

public class Usuario {
    String Cedula;
    String Nombres, Apellidos, Direccion,Telefono,Ciudad,Usuario, Celular, Contraseña, Email;
    public Usuario() {
    }
    public Usuario(String nombres, String apellidos, String direccion, String ciudad, String telefono, String celular, String usuario, String contraseña) {

        Nombres = nombres;
        Apellidos = apellidos;
        Direccion = direccion;
        Ciudad=ciudad;
        Telefono=telefono;
        Celular = celular;
        Usuario=usuario;
        Contraseña = contraseña;

    }
    public boolean isNull() {
        if (Nombres.equals("") && Apellidos.equals("") && Direccion.equals("") && Ciudad.equals("") && Telefono.equals("")  && Celular.equals("") && Usuario.equals("") && Contraseña.equals("")) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "Cedula=" + Cedula +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Direccion='" + Direccion + '\'' +
                ", Ciudad='" + Ciudad + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Celular='" + Celular + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Contraseña='" + Contraseña + '\'' +
                '}';
    }
    public String getCedula() { //envia
        return Cedula;
    }
    public void setCedula(String cedula) { // compara
        this.Cedula = cedula;
    }
    public String getNombres() {
        return Nombres;
    }
    public void setNombres(String nombres) {
        Nombres = nombres;
    }
    public String getApellidos() {
        return Apellidos;
    }
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }
    public String getCelular() {
        return Celular;
    }
    public void setCelular(String celular) {
        Celular = celular;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getDireccion() {
        return Direccion;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
    public String getCiudad() {
        return Ciudad;
    }
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
    public String getTelefono() {
        return Telefono;
    }
    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
    public String getUsuario() {
        return Usuario;
    }
    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

}
