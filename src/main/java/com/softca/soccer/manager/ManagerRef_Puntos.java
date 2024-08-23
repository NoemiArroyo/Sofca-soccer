package com.softca.soccer.manager;

import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerRef_Puntos {
    public void crear(Ref_Puntos refPuntos) throws ManageException;
    public Ref_Puntos selectById(Ref_Puntos refPuntos) throws ManageException;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete (Ref_Puntos refPuntos) throws ManageException;

}
