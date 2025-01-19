package com.softca.soccer.dao;

import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.Ref_PuntosMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class Ref_PuntosImplement implements Ref_PuntosDao {

    private final JdbcTemplate jdbcTemplate;

    public Ref_PuntosImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert( Ref_Puntos refPuntos) throws DaoException {
        String INSERT ="INSERT INTO ref_puntos(id, va_montoref, nu_puntosref) VALUES (?, ?, ?)";
        try{
            String uuid = UUID.randomUUID().toString();
            refPuntos.setId(uuid);
            jdbcTemplate.update(INSERT,refPuntos.getId(),refPuntos.getMontoRef(), refPuntos.getPuntosRef());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void update(Ref_Puntos refPuntos) throws DaoException {
        String update ="UPDATE ref_puntos\n" +
                "SET va_montoref=?, nu_puntosref=?\n" +
                "WHERE id=?";
        try{
            jdbcTemplate.update(update,refPuntos.getMontoRef(), refPuntos.getPuntosRef(), refPuntos.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }



    public void delete(Ref_Puntos refPuntos) throws DaoException {
        String DELETE ="DELETE FROM ref_puntos WHERE id=?";
        try{
            jdbcTemplate.update(DELETE,refPuntos.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public Ref_Puntos selectById (Ref_Puntos refPuntos){
        try{
            String QUERY = "SELECT va_montoref, nu_puntosref FROM ref_puntos WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new Ref_PuntosMapper(),refPuntos.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Map<String, Object>> selectAll() throws DaoException{
        String selectAll = "SELECT va_montoref, id, nu_puntosref FROM ref_puntos";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}
