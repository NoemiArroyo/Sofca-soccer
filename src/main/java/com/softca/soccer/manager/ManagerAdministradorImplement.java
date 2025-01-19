package com.softca.soccer.manager;

import com.softca.soccer.dao.AdministradorDao;
import com.softca.soccer.dto.Administrador;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerAdministradorImplement implements ManagerAdministrador {

    private AdministradorDao administradorDao;

    public ManagerAdministradorImplement (AdministradorDao administradorDao ) {
        this.administradorDao= administradorDao;
    }


    public void crear(Administrador administrador) throws ManageException {

        Administrador adminDato = null;

        try{
            adminDato = administradorDao.selectById(administrador);
                if(adminDato==null){
                    administradorDao.insert(administrador);
                }else{
                    administradorDao.update(administrador);
                }

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public Administrador selectById(Administrador administrador) throws ManageException{

        Administrador adminDato = null;
        try{
            adminDato =administradorDao.selectById(administrador);

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
        return adminDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{
        try{
            return this.administradorDao.selectAll();
        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

    }

    public  void  delete(Administrador administrador ) throws ManageException{
        try{
            if(administrador.getId()!=null){
                administradorDao.delete(administrador);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }


    }
}


