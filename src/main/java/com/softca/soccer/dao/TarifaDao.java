package com.softca.soccer.dao;

import com.softca.soccer.dto.Tarifa;


import java.util.List;

public interface TarifaDao {

    public void insert(Tarifa tarifa) ;
    public void update(Tarifa tarifa) ;
    public void delete(Tarifa tarifa);
    public Tarifa selectById( Tarifa tarifa);
    public List<Tarifa > selectAll();
}
