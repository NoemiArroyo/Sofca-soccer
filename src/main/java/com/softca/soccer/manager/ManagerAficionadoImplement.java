package com.softca.soccer.manager;

import com.softca.soccer.dao.AficionadoDao;
import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerAficionadoImplement implements ManagerAficionado {

    private AficionadoDao aficionadoDao;


    public ManagerAficionadoImplement(AficionadoDao aficionadoDao){
        this.aficionadoDao = aficionadoDao;
    }


    public void crear(Aficionado aficionado) throws ManageException{

            try{
                Aficionado afiDato = aficionadoDao.selectById(aficionado);

                if(afiDato==null){
                    aficionadoDao.insert(aficionado);
                }else{
                    aficionadoDao.update(aficionado);
                }
            }catch (DaoException ex){
                throw new ManageException(ex.getMessage());

            }catch (Exception ex){
                throw new ManageException(ex.getMessage());
            }
    }

    public Aficionado selectById(Aficionado aficionado) throws ManageException{

        Aficionado afiDato = null;
        try{
            afiDato = this.aficionadoDao.selectById(aficionado);
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

        return afiDato;

    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.aficionadoDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


    }

    public  void  delete(Aficionado aficionado ) throws ManageException{

        try{
            if(aficionado.getId()!=null){
                aficionadoDao.delete(aficionado);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }
}
