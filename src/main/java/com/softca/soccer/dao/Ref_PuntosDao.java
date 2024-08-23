package com.softca.soccer.dao;

import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface Ref_PuntosDao {
    public void insert(Ref_Puntos refPuntos) throws DaoException;
    public void update(Ref_Puntos refPuntos) throws DaoException;
    public void delete(Ref_Puntos refPuntos) throws DaoException;
    public Ref_Puntos selectById( Ref_Puntos refPuntos);
    public List<Map<String, Object>> selectAll() throws DaoException;
}

