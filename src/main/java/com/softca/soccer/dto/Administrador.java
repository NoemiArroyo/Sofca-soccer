package com.softca.soccer.dto;

public class Administrador {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String  nit;
    private String contra;
    private String id;

    public Administrador() {
        cedula = "";
        nombres = "";
        apellidos = "";
        email = "";
        nit = "";
        contra = "";
        id = "";
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCedula() {
        return cedula;
    }

    public String getId() {
        return id;
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

    public String getNit() {
        return nit;
    }

    public String getContra() {
        return contra;
    }
}
