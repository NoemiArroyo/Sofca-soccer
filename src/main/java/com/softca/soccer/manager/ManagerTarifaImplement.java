package com.softca.soccer.manager;

import com.softca.soccer.dao.TarifaDao;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerTarifaImplement implements ManagerTarifa {

    private TarifaDao tarifaDao;


    public ManagerTarifaImplement(TarifaDao tarifaDao){
            this.tarifaDao = tarifaDao;
    }


    public void crear(Tarifa tarifa) throws ManageException {


        try {
            Tarifa tarifaDato = tarifaDao.selectById(tarifa);

            if(tarifaDato==null){
                tarifaDao.insert(tarifa);
            }else{
                tarifaDao.update(tarifa);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


    }

    public Tarifa selectById(Tarifa tarifa) throws ManageException{


        Tarifa tarifaDato =null;
        try {
            tarifaDato = tarifaDao.selectById(tarifa);
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


        return tarifaDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException {

        try {

            return this.tarifaDao.selectAll();

        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public  void  delete(Tarifa tarifa ) throws ManageException{

        try {
            if(tarifa.getId()!=null){
                this.tarifaDao.delete(tarifa);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }
}
