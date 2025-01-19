package com.softca.soccer.dao;

import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.TarifasMapper;
import com.softca.soccer.mapper.TiendasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository

public class TiendaDaoImplement implements  TiendaDao {


    private final JdbcTemplate jdbcTemplate;


    public TiendaDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public void insert(Tiendas tiendas) throws DaoException {
    String INSERT = "INSERT INTO tienda (id, nu_nit_tienda, ds_tipo_tienda) VALUES (uuid_generate_v4()::text, ?, ?)";
    try{
        jdbcTemplate.update(INSERT,tiendas.getNit(), tiendas.getTipoTienda());
    }catch (Exception ex){
            throw new DaoException(ex);
    }
   }

    public void update(Tiendas tiendas) throws DaoException{
        String UPDATE = "UPDATE tienda SET ds_tipo_tienda=? WHERE nu_nit_tienda=?";
        try{
            jdbcTemplate.update(UPDATE, tiendas.getTipoTienda(),tiendas.getNit());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }

    public void delete(Tiendas tiendas)throws DaoException{
        String DELETE = "DELETE FROM tienda WHERE id=? ";
        try{
         jdbcTemplate.update(DELETE,tiendas.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public Tiendas selectById( Tiendas tiendas){

        try {
            String QUERY = "SELECT nu_nit_tienda,ds_tipo_tienda FROM tienda WHERE id=? ";
            return jdbcTemplate.queryForObject(QUERY, new TiendasMapper(),tiendas.getId());

        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Map<String, Object>> selectAll()throws DaoException{
        String selectAll = "SELECT id, nu_nit_tienda,ds_tipo_tienda\n" +
                    "FROM tienda";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);    }
        }
}
