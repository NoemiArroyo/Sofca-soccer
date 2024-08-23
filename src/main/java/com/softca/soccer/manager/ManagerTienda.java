package com.softca.soccer.manager;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;

import java.util.List;
import java.util.Map;

public interface ManagerTienda {

    public void crear(Tiendas tiendas) throws Exception;
    public Tiendas selectById(Tiendas tiendas) throws Exception;
    public List<Map<String, Object>> selectAll() throws Exception;
    public  void  delete(Tiendas tiendas ) throws Exception;
}
