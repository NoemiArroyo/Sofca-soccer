package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerTienda {

    public void crear(Tiendas tiendas) throws ManageException;
    public Tiendas selectById(Tiendas tiendas) throws ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Tiendas tiendas ) throws ManageException;
}
