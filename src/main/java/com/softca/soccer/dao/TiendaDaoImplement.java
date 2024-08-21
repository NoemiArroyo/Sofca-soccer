package com.softca.soccer.dao;

import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.mapper.TarifasMapper;
import com.softca.soccer.mapper.TiendasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository

public class TiendaDaoImplement implements  TiendaDao {


    private final JdbcTemplate jdbcTemplate;


    public TiendaDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public void insert(Tiendas tiendas){
    String INSERT = "INSERT INTO tienda (id, nu_nit_tienda, ds_tipo_tienda) VALUES (uuid_generate_v4()::text, ?, ?)";

    jdbcTemplate.update(INSERT,tiendas.getNit(), tiendas.getTipoTienda());
    }

    public void update(Tiendas tiendas){
        String UPDATE = "UPDATE tienda SET ds_tipo_tienda=? WHERE nu_nit_tienda=?";
        jdbcTemplate.update(UPDATE, tiendas.getTipoTienda(),tiendas.getNit());
    }

    public void delete(Tiendas tiendas){
        String DELETE = "DELETE FROM tienda WHERE id=? ";
        jdbcTemplate.update(DELETE,tiendas.getId());
    }

    public Tiendas selectById( Tiendas tiendas){

        try {
            String QUERY = "SELECT nu_nit_tienda,ds_tipo_tienda FROM tienda WHERE id=? ";
            return jdbcTemplate.queryForObject(QUERY, new TiendasMapper(),tiendas.getId());

        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Tiendas> selectAll(){
        String selectAll = "SELECT nu_nit_tienda,ds_tipo_tienda\n" +
                    "FROM tienda";

        return jdbcTemplate.query(selectAll, new TiendasMapper());
    }

}
