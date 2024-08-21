package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;

import java.util.List;

public interface ManagerTransacciones {

    public void crear(Transacciones transacciones) throws Exception;
    public Transacciones selectById(Transacciones transacciones) throws Exception;
    public List<Transacciones> selectAll() throws Exception;
    public  void  delete(Transacciones transacciones ) throws Exception;
}
