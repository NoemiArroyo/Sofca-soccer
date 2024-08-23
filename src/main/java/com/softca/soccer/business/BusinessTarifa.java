package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessTarifa {
    public void registrar( Tarifa tarifa ) throws BusinessException;
    public Tarifa selectById(Tarifa tarifa ) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Tarifa tarifa ) throws BusinessException;
}
