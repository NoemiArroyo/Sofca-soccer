package com.softca.soccer.dao;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.mapper.AdministradorMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class AdministradorImplement implements AdministradorDao {
    private final JdbcTemplate jdbcTemplate;

    public AdministradorImplement (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Administrador administrador) {
        String INSERT ="INSERT INTO public.administrador (id, ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseña ) VALUES (?, ?, ?,?,?,?,?)";

        String uuid = UUID.randomUUID().toString();
        administrador.setId(uuid);
        jdbcTemplate.update(INSERT, administrador.getId(),administrador.getCedula(), administrador.getNombres(), administrador.getApellidos(), administrador.getEmail(), administrador.getNit(), administrador.getContra());
    }



    public void update(Administrador administrador){
        String update ="UPDATE administrador\n" +
                "SET nu_nit_admin =?\n" +
                "WHERE id=?";
        jdbcTemplate.update(update,administrador.getNit(), administrador.getId());

    }



    public void delete(Administrador administrador){
        String DELETE ="DELETE FROM administrador WHERE id=?";
        jdbcTemplate.update(DELETE,administrador.getId());
    }



    public Administrador selectById( Administrador administrador){
        try{
            String QUERY = "SELECT ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseñaFROM Administrador WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new AdministradorMapper(), administrador.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Administrador> selectAll(){
        String selectAll = "SELECT ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseña FROM administrador";

        return jdbcTemplate.query(selectAll, new AdministradorMapper());
    }

}


