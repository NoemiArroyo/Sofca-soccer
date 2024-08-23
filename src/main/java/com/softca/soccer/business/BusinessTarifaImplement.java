package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerTarifa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Component

public class BusinessTarifaImplement implements BusinessTarifa{


    private ManagerTarifa managerTarifa;

    //constructor *********************************************************************++
    public BusinessTarifaImplement(ManagerTarifa managerTarifa) {

        this.managerTarifa = managerTarifa;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar( Tarifa tarifa ) throws BusinessException {
        try{
            managerTarifa.crear(tarifa);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }


    }

    @Transactional(readOnly = true)
    public Tarifa selectById(Tarifa tarifa ) throws BusinessException {
        Tarifa trfdata =null;
        try{
            trfdata= managerTarifa.selectById(tarifa);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

        return trfdata;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{
             return this. managerTarifa.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Tarifa tarifa ) throws BusinessException {
        try{
            this.managerTarifa.delete(tarifa);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }
}
