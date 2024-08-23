package com.softca.soccer.manager;

import com.softca.soccer.dao.TransaccionDao;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;


@Component
public class ManagerTransaccionesImplement  implements ManagerTransacciones{

    private TransaccionDao transaccionDao;

    public ManagerTransaccionesImplement(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
    }

    public void crear(Transacciones transacciones) throws ManageException{
        try{
            Transacciones trsDato = transaccionDao.selectById(transacciones);

            if(trsDato==null){
                transaccionDao.insert(transacciones);
            }else{
                transaccionDao.update(transacciones);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public Transacciones selectById(Transacciones transacciones) throws ManageException{
        Transacciones trsDato = null;
        try{
            trsDato = this.transaccionDao.selectById(transacciones);
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return trsDato;

    }

    public List<Map<String, Object>> selectAll() throws ManageException{

        try{
            return this.transaccionDao.selectAll();
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public  void  delete(Transacciones transacciones ) throws ManageException{
        try{
            if(transacciones.getId()!=null){
                transaccionDao.delete(transacciones);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }
}
