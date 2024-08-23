package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.DaoException;


import java.util.List;
import java.util.Map;

public interface TarifaDao {

    public void insert(Tarifa tarifa) throws DaoException;

    public void update(Tarifa tarifa) throws DaoException;

    public void delete(Tarifa tarifa) throws DaoException;

    public Tarifa selectById(Tarifa tarifa);

    public List<Map<String, Object>> selectAll() throws DaoException;
}