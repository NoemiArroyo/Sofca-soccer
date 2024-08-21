package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;

import java.util.List;

public interface BusinessTransacciones {

    public void registrar(Transacciones transacciones ) throws Exception;
    public Transacciones selectById(Transacciones transacciones ) throws Exception;
    public List<Transacciones> selectAll() throws Exception;
}
