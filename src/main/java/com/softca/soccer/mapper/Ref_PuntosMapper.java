package com.softca.soccer.mapper;

import com.softca.soccer.dto.Ref_Puntos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Ref_PuntosMapper implements RowMapper<Ref_Puntos> {
    @Override
    public Ref_Puntos mapRow(ResultSet resultSet, int i) throws SQLException {
        Ref_Puntos refPuntos =new Ref_Puntos();
        refPuntos.setMontoRef(resultSet.getInt("va_montoref"));
        refPuntos.setPuntosRef(resultSet.getInt("nu_puntosref"));
        return refPuntos;
    }

}
