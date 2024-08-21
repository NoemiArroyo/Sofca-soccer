package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import java.util.List;

public interface BusinessTarifa {
    public void registrar( Tarifa tarifa ) throws Exception;
    public Tarifa selectById(Tarifa tarifa ) throws Exception;
    public List<Tarifa> selectAll() throws Exception;
}
