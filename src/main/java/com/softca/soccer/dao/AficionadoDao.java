package com.softca.soccer.dao;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;

import java.util.List;

public interface AficionadoDao {


    public void insert(Aficionado aficionado) ;
    public void update(Aficionado aficionado) ;
    public void delete(Aficionado aficionado);
    public Aficionado selectById( Aficionado aficionado);
    public List<Aficionado> selectAll();
}
