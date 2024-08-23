package com.softca.soccer.dao;


import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.Reg_DescuentoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
     public class Reg_DescuentoDaoImplement implements Reg_DescuentoDao {

    private final JdbcTemplate jdbcTemplate;

    public Reg_DescuentoDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Reg_Descuento regDescuento) throws DaoException {

        String INSERT ="INSERT INTO reg_descuento(ds_tipo_desc, fe_desc, po_desc, id_aficionado, id_tarifa, nu_codigodesc, id) VALUES (?, ?, ?,?,?,?,?)";

        try{
            String uuid = UUID.randomUUID().toString();
            regDescuento.setId(uuid);
            jdbcTemplate.update(INSERT,regDescuento.getTipoDesc(), regDescuento.getFecha(),regDescuento.getPorcentaje(),regDescuento.getIdAfc().getId(), regDescuento.getIdTrf().getId(), regDescuento.getCodigoDesc(),regDescuento.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public void update(Reg_Descuento regDescuento) throws DaoException{
        String update ="UPDATE reg_descuento\n" +
                "SET ds_tipo_desc=?, fe_desc=?, po_desc=?, id_tarifa=?, nu_codigodesc=?\n" +
                "WHERE id=?";
        try{
            jdbcTemplate.update(update,regDescuento.getTipoDesc(), regDescuento.getFecha(), regDescuento.getPorcentaje(),regDescuento.getIdTrf(),regDescuento.getCodigoDesc(),regDescuento.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }

    public void delete(Reg_Descuento regDescuento) throws DaoException{
        String DELETE ="DELETE FROM reg_descuento WHERE id=?";
        try{
            jdbcTemplate.update(DELETE,regDescuento.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }



    public Reg_Descuento selectById( Reg_Descuento regDescuento){
        try{
            String QUERY = "SELECT ds_tipo_desc, fe_desc, po_desc, id_aficionado, id_tarifa, nu_codigodesc FROM reg_descuento WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new Reg_DescuentoMapper(), regDescuento.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Map<String, Object>> selectAll() throws DaoException{
        String selectAll = "SELECT id, po_desc, nu_codigodesc,id_aficionado,fe_desc, id_tarifa, ds_tipo_desc FROM reg_descuento";

        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }

}



