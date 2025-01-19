package com.softca.soccer.dao;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.AdministradorMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class AdministradorImplement implements AdministradorDao {
    private final JdbcTemplate jdbcTemplate;

    public AdministradorImplement (DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Administrador administrador) throws DaoException {
        String INSERT ="INSERT INTO public.administrador (id, ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseña ) VALUES (?, ?, ?,?,?,?,?)";
        try{
            String uuid = UUID.randomUUID().toString();
            administrador.setId(uuid);

            jdbcTemplate.update(INSERT, administrador.getId(),administrador.getCedula(), administrador.getNombres(), administrador.getApellidos(), administrador.getEmail(), administrador.getNit(), administrador.getContra());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void update(Administrador administrador) throws DaoException{
        String update ="UPDATE administrador SET ds_cc=?, ds_nombres=?, ds_apellidos=?, ds_email=?, nu_nit_admin=?, ds_contraseña=? WHERE id=?";
        try{
            jdbcTemplate.update(update,administrador.getCedula(), administrador.getNombres(), administrador.getApellidos(),administrador.getEmail(), administrador.getNit(), administrador.getContra(), administrador.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }



    public void delete(Administrador administrador){
        String DELETE ="DELETE FROM administrador WHERE id=?";
        try{
            jdbcTemplate.update(DELETE,administrador.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public Administrador selectById( Administrador administrador){
        try{
            String QUERY = "SELECT ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseña FROM Administrador WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new AdministradorMapper(), administrador.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Map<String, Object>> selectAll() throws DaoException {
        String selectAll = "SELECT ds_cc, ds_nombres, ds_apellidos, ds_email, nu_nit_admin, ds_contraseña, id FROM administrador";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


}


