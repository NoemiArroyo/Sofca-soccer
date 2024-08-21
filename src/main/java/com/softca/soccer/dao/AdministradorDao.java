package com.softca.soccer.dao;


import com.softca.soccer.dto.Administrador;

import java.util.List;

public interface AdministradorDao {
    public void insert(Administrador administrador) ;
    public void update(Administrador administrador) ;
    public void delete(Administrador administrador);
    public Administrador selectById( Administrador administrador);
    public List<Administrador > selectAll();
}
