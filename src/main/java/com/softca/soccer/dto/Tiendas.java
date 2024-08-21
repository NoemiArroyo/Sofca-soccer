package com.softca.soccer.dto;

public class Tiendas {

    private int nit;
    private String tipoTienda, id;

    public Tiendas() {
        this.tipoTienda = "";
        this.nit = 0;
        this.id = "";
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public void setTipoTienda(String tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public void setId(String id) {
        this.id = id;
    }

    ////////////////////////////

    public int getNit() {
        return nit;
    }

    public String getTipoTienda() {
        return tipoTienda;
    }

    public String getId() {
        return id;
    }
}
