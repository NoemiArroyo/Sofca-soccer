package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;

import java.util.List;

public interface TiendaDao {
    public void insert(Tiendas tiendas) ;
    public void update(Tiendas tiendas) ;
    public void delete(Tiendas tiendas);
    public Tiendas selectById( Tiendas tiendas);
    public List<Tiendas > selectAll();
}
