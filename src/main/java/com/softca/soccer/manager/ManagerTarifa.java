package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;

import java.util.List;

public interface ManagerTarifa {
    public void crear(Tarifa tarifa) throws Exception;
    public Tarifa selectById(Tarifa tarifa) throws Exception;
    public List<Tarifa> selectAll() throws Exception;
    public  void  delete(Tarifa tarifa ) throws Exception;

}
