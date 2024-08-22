package com.softca.soccer.dto;

import java.util.Date;

public class Reg_Descuento {

    private String id;
    private int  codigoDesc;
    private Date fecha;
    private String tipoDesc;
    private Aficionado idAfc;
    private Tarifa idTrf;
    private int porcentaje;

    public Reg_Descuento() {
        this.id = "";
        this.codigoDesc = 0;
        this.fecha = new Date();
        this.tipoDesc = "";
        this.idAfc = new Aficionado();
        this.idTrf = new Tarifa();
        this.porcentaje = 0;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public Tarifa getIdTrf() {
        return idTrf;
    }

    public void setIdTrf(Tarifa idTrf) {
        this.idTrf = idTrf;
    }

    public Aficionado getIdAfc() {
        return idAfc;
    }

    public void setIdAfc(Aficionado idAfc) {
        this.idAfc = idAfc;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCodigoDesc(int codigoDesc) {
        this.codigoDesc = codigoDesc;
    }


///////////////////////////////////////////////////////////////


    public String getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCodigoDesc() {
        return codigoDesc;
    }

    public String getTipoDesc() {
        return tipoDesc;
    }




}
