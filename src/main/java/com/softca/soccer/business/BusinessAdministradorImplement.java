package com.softca.soccer.business;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.manager.ManagerAdministrador;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BusinessAdministradorImplement implements BusinessAdministrador {

    private ManagerAdministrador managerAdministrador;


    public BusinessAdministradorImplement (ManagerAdministrador managerAdministrador) {

        this.managerAdministrador = managerAdministrador;
    }

    public void registrar( Administrador administrador ) throws Exception {
        managerAdministrador.crear(administrador);

    }


    public Administrador selectById( Administrador administrador) throws Exception{
        Administrador admindata =null;

        admindata = managerAdministrador.selectById(administrador);

        return admindata;
    }

    public List<Administrador> selectAll() throws Exception{
        List<Administrador> admindata =null;
        admindata = managerAdministrador.selectAll();

        return admindata;
    }
}
