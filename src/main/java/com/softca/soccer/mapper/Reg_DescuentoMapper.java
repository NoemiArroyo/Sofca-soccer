package com.softca.soccer.mapper;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.dto.Tarifa;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Reg_DescuentoMapper implements RowMapper<Reg_Descuento> {
    @Override

    public Reg_Descuento mapRow(ResultSet resultSet, int i) throws SQLException {
           Reg_Descuento regDescuento = new Reg_Descuento();
           Aficionado afi =new Aficionado();
            Tarifa  tr = new Tarifa();

        regDescuento.setId(resultSet.getString("id"));
        regDescuento.setTipoDesc (resultSet.getString("ds_tipo_desc"));
        regDescuento.setFecha(resultSet.getDate("fe_desc"));
        afi.setCedula (resultSet.getString("id_aficionado"));
        regDescuento.setCodigoDesc(resultSet.getInt("nu_codigodesc"));
        tr.setId (resultSet.getString("id_tarifa"));

        return regDescuento;
    }

}
