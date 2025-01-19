package com.softca.soccer.manager;

import com.softca.soccer.dto.Administrador;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerAdministrador {
    public void crear(Administrador administrador) throws Exception;
    public Administrador selectById(Administrador administrador) throws Exception;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Administrador administrador ) throws ManageException;
}
