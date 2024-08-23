package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerTarifa {
    public void crear(Tarifa tarifa) throws ManageException;
    public Tarifa selectById(Tarifa tarifa) throws ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Tarifa tarifa ) throws ManageException;

}
