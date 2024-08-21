package com.softca.soccer.mapper;

import com.softca.soccer.dto.Tarifa;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TarifasMapper  implements RowMapper<Tarifa> {

    @Override
    public Tarifa mapRow(ResultSet resultSet, int i) throws SQLException {
        Tarifa tarifa=new Tarifa();
        tarifa.setCantidadP(resultSet.getInt("nu_cantidadp"));
        tarifa.setPorcentaje(resultSet.getInt("po_porcentaje"));
        return tarifa;
    }

}
