package com.softca.soccer.manager;

import com.softca.soccer.dto.Ref_Puntos;

import java.util.List;

public interface ManagerRef_Puntos {
    public void crear(Ref_Puntos refPuntos) throws Exception;
    public Ref_Puntos selectById(Ref_Puntos refPuntos) throws Exception;
    public List<Ref_Puntos> selectAll() throws Exception;
    public  void  delete (Ref_Puntos refPuntos) throws Exception;
}
