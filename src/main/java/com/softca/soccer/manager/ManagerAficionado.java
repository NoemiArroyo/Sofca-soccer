package com.softca.soccer.manager;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerAficionado {

    public void crear(Aficionado aficionado) throws ManageException;
    public Aficionado selectById(Aficionado aficionado) throws ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Aficionado aficionado ) throws ManageException;

}
