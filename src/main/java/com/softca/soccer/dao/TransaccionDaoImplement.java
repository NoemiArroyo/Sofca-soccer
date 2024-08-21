package com.softca.soccer.dao;

import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.mapper.TransaccionesMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository

public class TransaccionDaoImplement implements TransaccionDao{

    private final JdbcTemplate jdbcTemplate;

    public TransaccionDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Transacciones transaccion) {
        String INSERT ="INSERT INTO transaccion( fe_compra," +
                                                " nu_factura," +
                                                " va_montoc," +
                                                " bo_estado," +
                                                " id_tienda," +
                                                " ds_cc_comprador," +
                                                " ds_tipo_compra," +
                                                " id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        String uuid = UUID.randomUUID().toString();
        transaccion.setId(uuid);
        jdbcTemplate.update(INSERT,
                transaccion.getFecha(),
                transaccion.getNumero(),
                transaccion.getMonto(),
                transaccion.getEstado(),
                transaccion.getidTnd().getId(),
                transaccion.getcc_comprador(),
                transaccion.getTipo_compra(),
                transaccion.getId());
    }

    public void update(Transacciones transaccion) {

        String update ="UPDATE transaccion SET ds_cc_comprador=? WHERE id=?";
        jdbcTemplate.update(update,transaccion.getcc_comprador(),transaccion.getId());

    }
    public void delete(Transacciones transaccion){

        String DELETE = "DELETE FROM transaccion WHERE id=? ";
        jdbcTemplate.update(DELETE,transaccion.getId());

    }
    public Transacciones selectById( Transacciones transaccion){

        try {
            String QUERY = "SELECT A.fe_compra,\n" +
                    "\t\tA.nu_factura,\n" +
                    "\t\tA.va_montoc,\n" +
                    "\t\tA.bo_estado,\n" +
                    "\t\tA.id_tienda,\n" +
                    "\t\tB.nu_nit_tienda,\n" +
                    "\t\tB.ds_tipo_tienda,\n" +
                    "\t\tA.ds_cc_comprador,\n" +
                    "\t\tA.ds_tipo_compra,\n" +
                    "\t\tA.id\n" +
                    " FROM transaccion A\n" +
                    "     INNER JOIN\n" +
                    "\t tienda B ON A.id_tienda=B.id" +
                    " WHERE  id=? ";
            return jdbcTemplate.queryForObject(QUERY, new TransaccionesMapper(),transaccion.getId());

        }catch (EmptyResultDataAccessException ex){
            return null;
        }

    }
    public List<Transacciones > selectAll(){

        String selectAll = "SELECT fe_compra, nu_factura, va_montoc, bo_estado, id_tienda, ds_cc_comprador, ds_tipo_compra FROM transaccion";

        return jdbcTemplate.query(selectAll, new TransaccionesMapper());

    }

}
