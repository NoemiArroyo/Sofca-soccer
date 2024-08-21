package com.softca.soccer.business;
import com.softca.soccer.dto.Ref_Puntos;

import java.util.List;

public interface BusinessRef_Puntos {
    public void registrar(Ref_Puntos refPuntos ) throws Exception;
    public Ref_Puntos selectById (Ref_Puntos refPuntos) throws Exception;
    public List<Ref_Puntos> selectAll() throws Exception;
}
