package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessTransacciones {

    public void registrar(Transacciones transacciones ) throws Exception;
    public Transacciones selectById(Transacciones transacciones ) throws Exception;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete(Transacciones transacciones) throws BusinessException;
}
