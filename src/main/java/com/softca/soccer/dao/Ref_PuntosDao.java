package com.softca.soccer.dao;

import com.softca.soccer.dto.Ref_Puntos;

import java.util.List;

public interface Ref_PuntosDao {
    public void insert(Ref_Puntos refPuntos) ;
    public void update(Ref_Puntos refPuntos) ;
    public void delete(Ref_Puntos refPuntos);
    public Ref_Puntos selectById( Ref_Puntos refPuntos);
    public List< Ref_Puntos > selectAll();
}

