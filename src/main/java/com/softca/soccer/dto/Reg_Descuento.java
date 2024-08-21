package com.softca.soccer.dto;

import java.util.Date;

public class Reg_Descuento {

    private String id;
    private int  codigoDesc;
    private Date fecha;
    private String tipoDesc;
    private Aficionado idAfc;
    private Tarifa idTrf;


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




    public Reg_Descuento( ) {
        idAfc = new Aficionado();
        idTrf = new Tarifa();
        tipoDesc = "";
        fecha =  new Date();
        codigoDesc = 0;
        id ="";
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
