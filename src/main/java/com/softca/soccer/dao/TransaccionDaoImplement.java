package com.softca.soccer.dao;

import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.TransaccionesMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository

public class TransaccionDaoImplement implements TransaccionDao{



    private final JdbcTemplate jdbcTemplate;

    public TransaccionDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Transacciones transaccion)throws DaoException {
        String INSERT ="INSERT INTO transaccion (\n" +
                "    fe_compra, \n" +
                "    nu_factura, \n" +
                "    va_montoc, \n" +
                "    bo_estado, \n" +
                "    id_tienda, \n" +
                "    ds_cc_comprador, \n" +
                "    ds_tipo_compra, \n" +
                "    id\n" +
                ") \n" +
                "VALUES (\n" +
                "    ?, \n" +
                "    ?, \n" +
                "    ?, \n" +
                "    ?, \n" +
                "    ?, \n" +
                "    ?, \n" +
                "    ?, \n" +
                "    uuid_generate_v4()::text " +
                ");";


        try{
            jdbcTemplate.update(INSERT,
                    transaccion.getFecha(),
                    transaccion.getNumero(),
                    transaccion.getMonto(),
                    transaccion.getEstado(),
                    transaccion.getidTnd().getId(),
                    transaccion.getcc_comprador(),
                    transaccion.getTipo_compra());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void update(Transacciones transaccion) throws DaoException{

        String update ="UPDATE transaccion SET ds_cc_comprador=? WHERE id=?";
        try{
            jdbcTemplate.update(update,transaccion.getcc_comprador(),transaccion.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

    public void delete(Transacciones transaccion) throws DaoException{

        String DELETE = "DELETE FROM transaccion WHERE id=? ";
        try{
            jdbcTemplate.update(DELETE,transaccion.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }


    public Transacciones selectById( Transacciones transaccion)throws DaoException{

        try {
            String QUERY = "SELECT A.fe_compra, A.nu_factura, A.va_montoc, A.bo_estado, A.id_tienda, B.nu_nit_tienda, B.ds_tipo_tienda, A.ds_cc_comprador, A.ds_tipo_compra, A.id FROM transaccion A INNER JOIN tienda B ON A.id_tienda = B.id WHERE A.id = ?";



            return jdbcTemplate.queryForObject(QUERY, new TransaccionesMapper(),transaccion.getId());

        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }
    public List<Map<String, Object>> selectAll() throws DaoException{

        String selectAll = "SELECT id, fe_compra, nu_factura, va_montoc, bo_estado, id_tienda, ds_cc_comprador, ds_tipo_compra FROM transaccion";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }


    }

}
