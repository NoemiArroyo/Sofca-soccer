package com.softca.soccer.business;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;


public interface BusinessTienda {

    public void registrar( Tiendas tienda ) throws BusinessException;
    public Tiendas selectById(Tiendas tienda ) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Tiendas tienda ) throws BusinessException;
}
