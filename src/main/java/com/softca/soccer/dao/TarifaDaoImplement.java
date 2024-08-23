package com.softca.soccer.dao;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.TarifasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class TarifaDaoImplement implements TarifaDao {

    private final JdbcTemplate jdbcTemplate;

    public TarifaDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Tarifa tarifa)  throws DaoException {
        String INSERT ="INSERT INTO public.tarifa(id, nu_cantidadp, po_porcentaje) VALUES (?, ?, ?)";
        try{
            String uuid = UUID.randomUUID().toString();
            tarifa.setId(uuid);
            jdbcTemplate.update(INSERT,tarifa.getId(),tarifa.getCantidadP(),tarifa.getPorcentaje());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }



    public void update(Tarifa tarifa)  throws DaoException {
        String update ="UPDATE tarifa SET po_porcentaje=? WHERE id=?";
        try{
            jdbcTemplate.update(update,tarifa.getPorcentaje(),tarifa.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void delete(Tarifa tarifa)  throws DaoException {
        String DELETE ="DELETE FROM tarifa WHERE id=?";
        try{
         jdbcTemplate.update(DELETE,tarifa.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public Tarifa selectById( Tarifa tarifa){
        try{
            String QUERY = "SELECT nu_cantidadp,po_porcentaje FROM tarifa WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new TarifasMapper(),tarifa.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Map<String, Object>> selectAll() throws DaoException{
        String selectAll = "SELECT id, nu_cantidadp,po_porcentaje FROM tarifa";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}


