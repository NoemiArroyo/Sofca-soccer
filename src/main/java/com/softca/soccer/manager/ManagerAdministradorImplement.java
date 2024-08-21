package com.softca.soccer.manager;

import com.softca.soccer.dao.AdministradorDao;
import com.softca.soccer.dto.Administrador;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerAdministradorImplement implements ManagerAdministrador {

    private AdministradorDao administradorDao;

    public ManagerAdministradorImplement (AdministradorDao administradorDao ) {
        this.administradorDao= administradorDao;
    }


    public void crear(Administrador administrador) throws Exception {

        Administrador adminDato = administradorDao.selectById(administrador);

        if(adminDato==null){
            administradorDao.insert(administrador);
        }else{
            administradorDao.update(administrador);
        }
    }

    public Administrador selectById(Administrador administrador) throws Exception{

        Administrador adminDato = administradorDao.selectById(administrador);
        return adminDato;
    }

    public List<Administrador> selectAll() throws Exception{
        List<Administrador> lista =  administradorDao.selectAll();
        return lista;
    }

    public  void  delete(Administrador administrador ) throws Exception{
        if(administrador.getId()!=null){
            administradorDao.delete(administrador);
        }


    }
}


