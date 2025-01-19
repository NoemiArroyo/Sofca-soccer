package com.softca.soccer.business;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerTienda;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component

public class BusinessTiendaImplement implements  BusinessTienda{

    private ManagerTienda managerTienda;

    //constructor *********************************************************************++
    public BusinessTiendaImplement(ManagerTienda managerTienda) {

        this.managerTienda = managerTienda;
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Tiendas tiendas) throws BusinessException {
        try {
            managerTienda.crear(tiendas);
        } catch (ManageException ex) {
            throw new BusinessException(ex.getMessage());
        } catch (Exception ex) {

        }
    }

    @Transactional(readOnly = true)
    public Tiendas selectById(Tiendas tiendas ) throws BusinessException {
        Tiendas tnddata =null;
        try{
            tnddata= this.managerTienda.selectById(tiendas);

        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return tnddata;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{

        try{
            return this.managerTienda.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete(Tiendas tiendas ) throws BusinessException{
        try{
            this.managerTienda.delete(tiendas);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }



}
