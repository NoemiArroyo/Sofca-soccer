package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface TiendaDao {
    public void insert(Tiendas tiendas) throws DaoException;
    public void update(Tiendas tiendas) throws DaoException;
    public void delete(Tiendas tiendas)throws DaoException;
    public Tiendas selectById( Tiendas tiendas) ;
    public List<Map<String, Object>> selectAll() throws DaoException;
}
