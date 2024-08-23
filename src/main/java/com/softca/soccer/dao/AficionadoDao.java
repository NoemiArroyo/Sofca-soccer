package com.softca.soccer.dao;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.DaoException;

import java.util.List;

public interface AficionadoDao {


    public void insert(Aficionado aficionado) throws DaoException;
    public void update(Aficionado aficionado) throws DaoException;
    public void delete(Aficionado aficionado) throws DaoException;
    public Aficionado selectById( Aficionado aficionado) throws DaoException;
    public List<Aficionado> selectAll() throws DaoException;
}
