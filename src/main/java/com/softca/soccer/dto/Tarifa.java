package com.softca.soccer.dto;

public class Tarifa {

    private String id;
    private int cantidadP, porcentaje;


    public Tarifa() {
        this.cantidadP = 0;
        this.porcentaje = 0;
        this.id = "";
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public int getPorcentaje() {
        return porcentaje;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
