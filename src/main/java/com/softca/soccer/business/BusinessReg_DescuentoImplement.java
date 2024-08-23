package com.softca.soccer.business;


import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerReg_Descuento;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Component
public class BusinessReg_DescuentoImplement implements BusinessReg_Descuento {

    private ManagerReg_Descuento managerRegDescuento ;

    //CONSTRUCTOR************************************************************************+
    public BusinessReg_DescuentoImplement (ManagerReg_Descuento managerRegDescuento) {
        this.managerRegDescuento = managerRegDescuento;

    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar( Reg_Descuento regDescuento ) throws BusinessException {
        try{
            this.managerRegDescuento.crear(regDescuento);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public  Reg_Descuento selectById(Reg_Descuento regDescuento ) throws BusinessException{
        Reg_Descuento rd =null;
        try{
            rd= managerRegDescuento.selectById(regDescuento);
        }catch (ManageException ex){
            throw new BusinessException(ex.getMessage());

        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

        return rd;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{
            return  this.managerRegDescuento.selectAll();
        }catch (ManageException ex){
            throw new BusinessException(ex.getMessage());

        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Reg_Descuento regDescuento ) throws BusinessException {
        try{
            this.managerRegDescuento.delete(regDescuento);
        } catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        } catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }
}


