package com.softca.soccer.manager;


import com.softca.soccer.dao.Reg_DescuentoDao;
import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.exception.DaoException;
import com.softca.soccer.exception.ManageException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ManagerReg_DescuentoImplement implements ManagerReg_Descuento {

    private Reg_DescuentoDao regDescuentoDao ;

    public ManagerReg_DescuentoImplement (Reg_DescuentoDao regDescuentoDao){
        this.regDescuentoDao = regDescuentoDao  ;
    }


    public void crear (Reg_Descuento regDescuento) throws ManageException {
        try{
            Reg_Descuento regDescuentoDato = regDescuentoDao.selectById(regDescuento);

            if(regDescuentoDato==null){
                regDescuentoDao.insert ( regDescuento);
            }else{
                regDescuentoDao.update(regDescuento);
            }
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws ManageException{

        Reg_Descuento reg_DescuentoDato = null;
        try{
            reg_DescuentoDato = this.regDescuentoDao.selectById(regDescuento);
        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }

        return reg_DescuentoDato;
    }

    public List<Map<String, Object>> selectAll() throws ManageException{

        try{
            return this.regDescuentoDao.selectAll();

        }catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        }catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }

    public  void  delete(Reg_Descuento regDescuento ) throws ManageException{
         try{
            if (regDescuento.getId()!=null){
                regDescuentoDao.delete( regDescuento);
            }

        } catch (DaoException ex){
            throw new ManageException(ex.getMessage());

        } catch (Exception ex){
            throw new ManageException(ex.getMessage());
        }
    }
}


