package com.softca.soccer.dto;

public class Ref_Puntos {
    private String id;
    private int montoRef, puntosRef;

    public Ref_Puntos() {
        this.montoRef = 0;
        this.puntosRef = 0;
        id = "";
    }

    public void setMontoRef(int montoRef) {
        this.montoRef = montoRef;
    }

    public void setPuntosRef(int puntosRef) {
        this.puntosRef = puntosRef;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getMontoRef() {
        return montoRef;
    }

    public int getPuntosRef() {
        return puntosRef;
    }
/////////////////////////////////////////////

}
