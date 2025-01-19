package com.softca.soccer.business;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinesAficionado {
    public void registrar(Aficionado aficionado) throws BusinessException;
    public Aficionado selectById(Aficionado aficionado ) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Aficionado aficionado ) throws BusinessException;
}
