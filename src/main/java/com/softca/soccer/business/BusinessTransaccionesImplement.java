package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerTransacciones;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional

public class BusinessTransaccionesImplement implements  BusinessTransacciones{

    private ManagerTransacciones managerTransacciones;


    //constructor *********************************************************************++
    public BusinessTransaccionesImplement( ManagerTransacciones managerTransacciones) {
        this.managerTransacciones = managerTransacciones;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Transacciones transacciones ) throws BusinessException{
        try{
            managerTransacciones.crear(transacciones);
        } catch (
        ManageException ex) {
            throw new BusinessException(ex.getMessage());
        } catch (Exception ex) {

        }

    }

    @Transactional(readOnly = true)
    public Transacciones selectById(Transacciones transacciones ) throws BusinessException{
        Transacciones trsdata =null;
        try{
            trsdata= managerTransacciones.selectById(transacciones);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return trsdata;

    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{

        try{
            return this.managerTransacciones.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete(Transacciones transacciones ) throws BusinessException{
        try{
            this.managerTransacciones.delete(transacciones);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

}
