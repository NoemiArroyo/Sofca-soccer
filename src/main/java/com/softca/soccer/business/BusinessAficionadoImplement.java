package com.softca.soccer.business;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.BusinessException;
import com.softca.soccer.exception.ManageException;
import com.softca.soccer.manager.ManagerAficionado;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class BusinessAficionadoImplement  implements BusinesAficionado{

    private ManagerAficionado managerAficionado;


    //constructor *********************************************************************++
    public BusinessAficionadoImplement(ManagerAficionado managerAficionado) {
        this.managerAficionado = managerAficionado;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void registrar(Aficionado aficionado) throws BusinessException{
        try{
            managerAficionado.crear(aficionado);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Aficionado selectById(Aficionado aficionado ) throws BusinessException{
        Aficionado afndata =null;
        try{
            afndata= managerAficionado.selectById(aficionado);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }
        return afndata;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> selectAll() throws BusinessException{

        try{
            return this.managerAficionado.selectAll();
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }


    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = BusinessException.class)
    public void delete( Aficionado aficionado ) throws BusinessException{
        try{
            this.managerAficionado.delete(aficionado);
        }catch(ManageException ex){
            throw new BusinessException(ex.getMessage());
        }catch (Exception ex){
            throw new BusinessException(ex.getMessage());
        }

    }
}
