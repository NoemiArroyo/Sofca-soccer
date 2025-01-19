package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerTransacciones {

    public void crear(Transacciones transacciones) throws ManageException;
    public Transacciones selectById(Transacciones transacciones) throws ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Transacciones transacciones ) throws ManageException;
}
