package com.softca.soccer.manager;

import com.softca.soccer.dto.Administrador;

import java.util.List;

public interface ManagerAdministrador {
    public void crear(Administrador administrador) throws Exception;
    public Administrador selectById(Administrador administrador) throws Exception;
    public List<Administrador> selectAll() throws Exception;
    public  void  delete( Administrador administrador) throws Exception;
}
