package com.softca.soccer.dao;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.mapper.TarifasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class TarifaDaoImplement implements TarifaDao {

    private final JdbcTemplate jdbcTemplate;

    public TarifaDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Tarifa tarifa) {
        String INSERT ="INSERT INTO public.tarifa(id, nu_cantidadp, po_porcentaje) VALUES (?, ?, ?)";

        String uuid = UUID.randomUUID().toString();
        tarifa.setId(uuid);
        jdbcTemplate.update(INSERT,tarifa.getId(),tarifa.getCantidadP(),tarifa.getPorcentaje());
    }



    public void update(Tarifa tarifa){
        String update ="UPDATE tarifa SET po_porcentaje=? WHERE id=?";
        jdbcTemplate.update(update,tarifa.getPorcentaje(),tarifa.getId());

    }



    public void delete(Tarifa tarifa){
        String DELETE ="DELETE FROM tarifa WHERE id=?";
        jdbcTemplate.update(DELETE,tarifa.getId());
    }



    public Tarifa selectById( Tarifa tarifa){
        try{
            String QUERY = "SELECT nu_cantidadp,po_porcentaje FROM tarifa WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new TarifasMapper(),tarifa.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Tarifa > selectAll(){
        String selectAll = "SELECT nu_cantidadp,po_porcentaje FROM tarifa";

        return jdbcTemplate.query(selectAll, new TarifasMapper());
    }

}


