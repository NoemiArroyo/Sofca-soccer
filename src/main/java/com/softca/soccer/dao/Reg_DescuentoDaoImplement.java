package com.softca.soccer.dao;


import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.mapper.Reg_DescuentoMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
     public class Reg_DescuentoDaoImplement implements Reg_DescuentoDao {

    private final JdbcTemplate jdbcTemplate;

    public Reg_DescuentoDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Reg_Descuento regDescuento) {
        String INSERT ="INSERT INTO reg_descuento(ds_tipo_desc, fe_desc, po_desc, id_aficionado, id_tarifa, nu_codigodesc, id) VALUES (?, ?, ?,?,?,?,?)";

        String uuid = UUID.randomUUID().toString();
         regDescuento.setId(uuid);
        jdbcTemplate.update(INSERT,regDescuento.getTipoDesc(), regDescuento.getFecha(),regDescuento.getPorcentaje(),regDescuento.getIdAfc().getId(), regDescuento.getIdTrf().getId(), regDescuento.getCodigoDesc(),regDescuento.getId());
    }



    public void update(Reg_Descuento regDescuento){
        String update ="UPDATE reg_descuento\n" +
                "SET nu_codigodesc=?\n" +
                "WHERE id=?";
        jdbcTemplate.update(update,regDescuento.getCodigoDesc(),regDescuento.getId());

    }

    public void delete(Reg_Descuento regDescuento){
        String DELETE ="DELETE FROM reg_descuento WHERE id=?";
        jdbcTemplate.update(DELETE,regDescuento.getId());
    }



    public Reg_Descuento selectById( Reg_Descuento regDescuento){
        try{
            String QUERY = "SELECT ds_tipo_desc, fe_desc, po_desc, id_aficionado, id_tarifa, nu_codigodesc FROM reg_descuento WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new Reg_DescuentoMapper(), regDescuento.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List<Reg_Descuento > selectAll(){
        String selectAll = "SELECT po_desc, nu_codigodesc,id_aficionado,fe_desc, id_tarifa, ds_tipo_desc FROM reg_descuento";

        return jdbcTemplate.query(selectAll, new Reg_DescuentoMapper());
    }

}



