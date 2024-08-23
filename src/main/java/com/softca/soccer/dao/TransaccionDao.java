package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.DaoException;

import java.util.List;

public interface TransaccionDao {
    public void insert(Transacciones transaccion) throws DaoException;
    public void update(Transacciones transaccion) throws DaoException;
    public void delete(Transacciones transaccion) throws DaoException;
    public Transacciones selectById( Transacciones transaccion) ;
    public List<Transacciones > selectAll() throws DaoException;
}
