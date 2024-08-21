package com.softca.soccer.business;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;

import java.util.List;

public interface BusinesAficionado {
    public void registrar(Aficionado aficionado) throws Exception;
    public Aficionado selectById(Aficionado aficionado ) throws Exception;
    public List<Aficionado> selectAll() throws Exception;
}
