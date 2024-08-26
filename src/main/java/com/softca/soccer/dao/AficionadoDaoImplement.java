package com.softca.soccer.dao;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.mapper.AficionadoMaper;
import com.softca.soccer.mapper.TarifasMapper;
import com.softca.soccer.mapper.TiendasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class AficionadoDaoImplement implements AficionadoDao {

    private final JdbcTemplate jdbcTemplate;


    //COSNTRUCTOR**********************************************************************************
    public AficionadoDaoImplement(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Aficionado aficionado) throws DaoException{
        String INSERT = "INSERT INTO aficionado(id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
                if (aficionado.getEdad()>=18) {
                    String uuid = UUID.randomUUID().toString();
                    aficionado.setId(uuid);
                    jdbcTemplate.update(INSERT, aficionado.getId(), aficionado.getNombres(), aficionado.getApellidos(), aficionado.getCedula(), aficionado.getEmail(), aficionado.getMunicipio(), aficionado.getDepartamento(), aficionado.getContrasena(), aficionado.getPuntos(), aficionado.getEdad());
                }else {
                    System.out.println("LOS MENORES DE EDAD NO PUEDEN REGISTRARSE!");
                }
            }catch (Exception ex){
                throw new DaoException(ex);
            }

    }



    public void update(Aficionado aficionado) throws DaoException {

        String update ="UPDATE aficionado SET ds_nombres=?, ds_apellidos=?, ds_cedula=?, " +
                        "ds_email=?, ds_municipio=?, ds_departamento=?, " +
                        "ds_contraseña=?, nu_puntos_acumulados=?, nuedad=? WHERE id=?";
        try{
            jdbcTemplate.update(update,aficionado.getNombres(), aficionado.getApellidos(),
                    aficionado.getCedula(), aficionado.getEmail(), aficionado.getMunicipio(),
                    aficionado.getDepartamento(), aficionado.getContrasena(), aficionado.getPuntos(),
                    aficionado.getEdad(), aficionado.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }
    }


    public void delete(Aficionado aficionado) throws DaoException{
        String DELETE ="DELETE FROM aficionado WHERE id=?";
        try{
            jdbcTemplate.update(DELETE,aficionado.getId());
        }catch (Exception ex){
            throw new DaoException(ex);
        }


    }
    public Aficionado selectById( Aficionado aficionado){

        try{

            String QUERY = "SELECT id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad FROM aficionado where id=?";

            return jdbcTemplate.queryForObject(QUERY, new AficionadoMaper(), aficionado.getId());
        } catch(EmptyResultDataAccessException ex){
            return null;
        }

    }
    public List<Map<String, Object>> selectAll() throws DaoException{

        String selectAll = "SELECT id, ds_nombres, ds_apellidos, ds_cedula, ds_email, ds_municipio, ds_departamento, ds_contraseña, nu_puntos_acumulados, nuedad FROM aficionado;   ";
        try{
            return jdbcTemplate.queryForList(selectAll);
        }catch (Exception ex){
            throw new DaoException(ex);
        }

    }
}
