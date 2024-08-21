package com.softca.soccer.dao;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.mapper.AficionadoMaper;
import com.softca.soccer.mapper.TarifasMapper;
import com.softca.soccer.mapper.TiendasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class AficionadoDaoImplement implements AficionadoDao {

    private final JdbcTemplate jdbcTemplate;

    public AficionadoDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Aficionado aficionado) {
        if (aficionado.getEdad()>=18) {
            String INSERT = "INSERT INTO aficionado(id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            String uuid = UUID.randomUUID().toString();
            aficionado.setId(uuid);
            jdbcTemplate.update(INSERT, aficionado.getId(), aficionado.getNombres(), aficionado.getApellidos(), aficionado.getCedula(), aficionado.getEmail(), aficionado.getMunicipio(), aficionado.getDepartamento(), aficionado.getContrasena(), aficionado.getPuntos(), aficionado.getEdad());
        }else {
            System.out.println("LOS MENORES DE EDAD NO PIUEDEN REGISTRARSE");
        }

    }
    public void update(Aficionado aficionado) {

            String update ="UPDATE aficionado SET ds_cedula=? WHERE id=?";
            jdbcTemplate.update(update,aficionado.getCedula(),aficionado.getId());






    }
    public void delete(Aficionado aficionado){
        String DELETE ="DELETE FROM aficionado WHERE id=?";
        jdbcTemplate.update(DELETE,aficionado.getId());


    }
    public Aficionado selectById( Aficionado aficionado){

        try{

            String QUERY = "SELECT id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad FROM aficionado where id=?";

            return jdbcTemplate.queryForObject(QUERY, new AficionadoMaper(), aficionado.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }

    }
    public List<Aficionado> selectAll(){

        String selectAll = "SELECT id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad FROM aficionado;   ";

        return jdbcTemplate.query(selectAll, new AficionadoMaper());

    }
}
