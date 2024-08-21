package com.softca.soccer.manager;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;

import java.util.List;

public interface ManagerAficionado {

    public void crear(Aficionado aficionado) throws Exception;
    public Aficionado selectById(Aficionado aficionado) throws Exception;
    public List<Aficionado> selectAll() throws Exception;
    public  void  delete(Aficionado aficionado ) throws Exception;

}
