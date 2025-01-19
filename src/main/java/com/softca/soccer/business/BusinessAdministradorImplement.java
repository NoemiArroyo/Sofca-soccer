package com.softca.soccer.business;


import com.softca.soccer.dto.Administrador;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerAdministrador;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component

public class BusinessAdministradorImplement implements BusinessAdministrador {

    private ManagerAdministrador managerAdministrador;


    public BusinessAdministradorImplement (ManagerAdministrador managerAdministrador) {

        this.managerAdministrador = managerAdministrador;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar( Administrador administrador ) throws BusinessException {
        try{
            managerAdministrador.crear(administrador);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public Administrador selectById( Administrador administrador) throws BusinessException{
        Administrador admindata =null;
        try{
            admindata = managerAdministrador.selectById(administrador);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

        return admindata;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{

            return  this.managerAdministrador.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Administrador administrador ) throws BusinessException{
        try{
            this.managerAdministrador.delete(administrador);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }
}
