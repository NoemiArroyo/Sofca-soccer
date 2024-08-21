package com.softca.soccer.mapper;
import com.softca.soccer.dto.Tiendas;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TiendasMapper implements  RowMapper<Tiendas> {

    @Override
    public Tiendas mapRow(ResultSet resultSet, int i) throws SQLException {
        Tiendas tienda = new Tiendas();
        tienda.setNit(resultSet.getInt("nu_nit_tienda"));
        tienda.setTipoTienda(resultSet.getString("ds_tipo_tienda"));
        return tienda;
    }


}
