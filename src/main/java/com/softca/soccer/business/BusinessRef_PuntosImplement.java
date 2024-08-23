package com.softca.soccer.business;


import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerRef_Puntos;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class BusinessRef_PuntosImplement implements BusinessRef_Puntos {

    private ManagerRef_Puntos managerRefPuntos;

    //CONSTRUCTOR*****************************************
    public  BusinessRef_PuntosImplement (ManagerRef_Puntos managerRefPuntos) {
        this.managerRefPuntos = managerRefPuntos;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar( Ref_Puntos refPuntos ) throws BusinessException {
       try{
           managerRefPuntos.crear(refPuntos );
       }catch(ManageException ex){
           throw new BusinessException(ex.getMessage());
       }catch (Exception ex){
           throw new BusinessException(ex.getMessage());
       }

    }



    @Transactional(readOnly=true)
    public Ref_Puntos selectById( Ref_Puntos refPuntos) throws BusinessException{
        Ref_Puntos rpdata =null;

        try{
            rpdata= managerRefPuntos.selectById(refPuntos);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

        return  rpdata;
    }



    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{
        try{
            return this.managerRefPuntos.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }


    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Ref_Puntos refPuntos) throws BusinessException {
        try{
            this.managerRefPuntos.delete(refPuntos);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }
}