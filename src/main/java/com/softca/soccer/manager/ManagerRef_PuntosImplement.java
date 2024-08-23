package com.softca.soccer.manager;

import com.softca.soccer.dao.Ref_PuntosDao;
import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerRef_PuntosImplement implements ManagerRef_Puntos {

    private Ref_PuntosDao refPuntosDao;

    public ManagerRef_PuntosImplement (Ref_PuntosDao refPuntosDao) {
        this.refPuntosDao = refPuntosDao;
    }

    public void crear(Ref_Puntos refPuntos) throws ManageException {
        try{
            Ref_Puntos ref_puntosDato = refPuntosDao.selectById(refPuntos);

            if(ref_puntosDato==null){
                refPuntosDao.insert (refPuntos);
            }else{
                refPuntosDao.update(refPuntos);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public Ref_Puntos selectById(Ref_Puntos refPuntos) throws ManageException{

        Ref_Puntos ref_puntosDato = null;
        try{
            ref_puntosDato = this.refPuntosDao.selectById(refPuntos);
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


        return ref_puntosDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.refPuntosDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public  void  delete (Ref_Puntos refPuntos) throws ManageException{
        try{
            if(refPuntos.getId()!=null){
                refPuntosDao.delete(refPuntos);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }
}

