package com.softca.soccer.dao;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface AdministradorDao {
    public void insert(Administrador administrador) throws DaoException;
    public void update(Administrador administrador) throws DaoException;
    public void delete(Administrador administrador) throws DaoException;
    public Administrador selectById( Administrador administrador);
    public List<Map<String, Object>> selectAll() throws DaoException;
}
