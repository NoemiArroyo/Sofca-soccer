package com.softca.soccer.mapper;

import com.softca.soccer.dto.Aficionado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AficionadoMaper implements RowMapper<Aficionado> {

    @Override
    public Aficionado mapRow(ResultSet resultSet, int i) throws SQLException {
        Aficionado aficionado =  new Aficionado();
        aficionado.setApellidos(resultSet.getString("ds_apellidos"));
        aficionado.setCedula(resultSet.getString("ds_cedula"));
        aficionado.setEmail(resultSet.getString("ds_email"));
        aficionado.setEdad(resultSet.getInt("nuedad"));
        aficionado.setDepartamento(resultSet.getString("ds_departamento"));
        aficionado.setContrasena(resultSet.getString("ds_contraseña"));
        aficionado.setMunicipio(resultSet.getString("ds_municipio"));
        aficionado.setNombres(resultSet.getString("ds_nombres"));
        aficionado.setPuntos(resultSet.getInt("nu_puntos_acumulados"));

        return aficionado;
    }
}
