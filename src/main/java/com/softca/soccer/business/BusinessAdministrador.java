package com.softca.soccer.business;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessAdministrador {
    public void registrar( Administrador administrador ) throws BusinessException;
    public Administrador selectById(Administrador administrador ) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Administrador administrador ) throws BusinessException;

}

