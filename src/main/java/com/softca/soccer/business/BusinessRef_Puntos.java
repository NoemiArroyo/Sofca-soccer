package com.softca.soccer.business;
import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessRef_Puntos {
    public void registrar(Ref_Puntos refPuntos ) throws BusinessException;
    public Ref_Puntos selectById (Ref_Puntos refPuntos) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Ref_Puntos refPuntos ) throws BusinessException;
}
