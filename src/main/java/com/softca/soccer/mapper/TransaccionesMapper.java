package com.softca.soccer.mapper;

import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionesMapper  implements RowMapper<Transacciones> {

    @Override
    public Transacciones mapRow(ResultSet resultSet, int i) throws SQLException {
        Transacciones transacciones=new Transacciones();
        Tiendas tiendas=new Tiendas();
        transacciones.setcc_comprador(resultSet.getString("ds_cc_comprador"));
        transacciones.setEstado(resultSet.getBoolean("bo_estado"));
        transacciones.setFecha(resultSet.getDate("fe_compra"));
        transacciones.setMonto(resultSet.getInt("va_montoc"));
        transacciones.setNumero(resultSet.getInt("nu_factura"));
        transacciones.setTipo_compra(resultSet.getString("ds_tipo_compra"));

        tiendas.setId(resultSet.getString("id_tienda"));
        transacciones.setidTnd(tiendas);

        return transacciones;
    }


}
