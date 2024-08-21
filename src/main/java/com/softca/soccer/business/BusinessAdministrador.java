package com.softca.soccer.business;


import com.softca.soccer.dto.Administrador;

import java.util.List;

public interface BusinessAdministrador {
    public void registrar( Administrador tarifa ) throws Exception;
    public Administrador selectById(Administrador administrador ) throws Exception;
    public List<Administrador> selectAll() throws Exception;
}
