package com.softca.soccer.manager;
import com.softca.soccer.dao.TiendaDao;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;
import com.softca.soccer.dto.Tiendas;
import java.util.List;
import java.util.Map;


@Component
public class ManagerTiendaImplement implements ManagerTienda{

    private TiendaDao tiendasDao;


    public ManagerTiendaImplement(TiendaDao tiendaDao) {
        this.tiendasDao = tiendaDao;
    }


    public void crear(Tiendas tienda) throws ManageException {
        try{
            Tiendas tiendaDato = tiendasDao.selectById(tienda);

                if(tiendaDato==null){
                    tiendasDao.insert(tienda);
                }else{
                    tiendasDao.update(tienda);
                }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public Tiendas selectById(Tiendas tienda) throws ManageException{
        Tiendas tiendaDato = null;

        try{
            tiendaDato = tiendasDao.selectById(tienda);

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return tiendaDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.tiendasDao.selectAll();
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public  void  delete(Tiendas tiendas ) throws ManageException {
        try{
            if(tiendas.getId()!=null){
                tiendasDao.delete(tiendas);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


    }
}
