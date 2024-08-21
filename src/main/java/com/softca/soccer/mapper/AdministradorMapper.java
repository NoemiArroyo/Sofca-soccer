package com.softca.soccer.mapper;


import com.softca.soccer.dto.Administrador;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorMapper implements RowMapper<Administrador> {
    public Administrador mapRow(ResultSet resultSet, int i) throws SQLException {
        Administrador administrador = new Administrador();

        administrador.setCedula(resultSet.getInt("ds_cc"));
        administrador.setNombres(resultSet.getString("ds_nombres"));
        administrador.setApellidos(resultSet.getString("ds_apellidos"));
        administrador.setEmail(resultSet.getString("ds_email"));
        administrador.setNit(resultSet.getString("nu_nit_admin"));
        administrador.setContra(resultSet.getString("ds_contraseña"));

        return administrador;
    }
}
