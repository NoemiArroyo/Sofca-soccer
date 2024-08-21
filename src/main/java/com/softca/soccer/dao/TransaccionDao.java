package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;

import java.util.List;

public interface TransaccionDao {
    public void insert(Transacciones transaccion) ;
    public void update(Transacciones transaccion) ;
    public void delete(Transacciones transaccion);
    public Transacciones selectById( Transacciones transaccion);
    public List<Transacciones > selectAll();
}
