package com.softca.soccer.dao;

import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.mapper.Ref_PuntosMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class Ref_PuntosImplement implements Ref_PuntosDao {

    private final JdbcTemplate jdbcTemplate;

    public Ref_PuntosImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert( Ref_Puntos refPuntos) {
        String INSERT ="INSERT INTO public.ref_puntos(id, va_montoref, nu_puntosref) VALUES (?, ?, ?)";

        String uuid = UUID.randomUUID().toString();
        refPuntos.setId(uuid);
        jdbcTemplate.update(INSERT,refPuntos.getId(),refPuntos.getMontoRef(), refPuntos.getPuntosRef());
    }



    public void update(Ref_Puntos refPuntos){
        String update ="UPDATE ref_puntos\n" +
                "SET nu_puntosref=?\n" +
                "WHERE id=?";
        jdbcTemplate.update(update,refPuntos.getMontoRef(), refPuntos.getPuntosRef());

    }



    public void delete(Ref_Puntos refPuntos){
        String DELETE ="DELETE FROM ref_puntos WHERE id=?";
        jdbcTemplate.update(DELETE,refPuntos.getId());
    }



    public Ref_Puntos selectById (Ref_Puntos refPuntos){
        try{
            String QUERY = "SELECT nva_montoref, nu_puntosref FROM ref_puntos WHERE id=?";

            return jdbcTemplate.queryForObject(QUERY, new Ref_PuntosMapper(),refPuntos.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }
    }


    public List <Ref_Puntos> selectAll(){
        String selectAll = "SELECT nu_cantidadp,po_porcentaje FROM tarifa";

        return jdbcTemplate.query(selectAll, new Ref_PuntosMapper());
    }

}
