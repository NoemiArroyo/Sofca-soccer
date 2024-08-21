package com.softca.soccer.dto;

public class Aficionado {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String municipio;
    private String departamento;
    private int puntos;
    private String contrasena, id;
    private int edad;





    public Aficionado() {
        cedula = "";
        nombres = "";
        apellidos = "";
        email = "";
        municipio = "";
        departamento = "";
        puntos = 0;
        id = "";
        contrasena="";
        edad=0;

    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(String id) {
        this.id = id;
    }
    ////////////////////////////////////////////////////

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public String getId() {
        return id;
    }
}
