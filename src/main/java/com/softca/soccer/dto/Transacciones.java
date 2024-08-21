package com.softca.soccer.dto;
import java.util.Date;

public class Transacciones {

    private int numero, monto;
    private Date fecha;
    private boolean estado;
    private String cc_comprador, tipo_compra, id;
    private Tiendas idTnd;


    public Transacciones() {
        this.numero = 0;
        this.idTnd = new Tiendas();
        this.tipo_compra = "";
        this.cc_comprador = "";
        this.estado = false; //LAS TRANSACCIONES REGISTRADAS INCIAN EN FALSE PARA INDICAR QUE NO SE HA REDIMIDO ESA TRANSACCION
        this.fecha = new Date();
        this.monto = 0;
        this.id = "";
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setcc_comprador(String cc_comprador) {
        this.cc_comprador = cc_comprador;
    }

    public void setTipo_compra(String tipo_compra) {
        this.tipo_compra = tipo_compra;
    }

    public void setidTnd(Tiendas tiendas) {
        this.idTnd = tiendas;
    }

    public void setId(String id) {
        this.id = id;
    }
    ////////////////////////////////////////////////////


    public int getNumero() {
        return numero;
    }

    public int getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean getEstado() {
        return estado;
    }

    public String getcc_comprador() {
        return cc_comprador;
    }

    public String getTipo_compra() {
        return tipo_compra;
    }

    public Tiendas getidTnd() {
        return idTnd;
    }

    public String getId() {
        return id;
    }
}
