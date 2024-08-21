package com.softca.soccer.manager;


import com.softca.soccer.dao.Reg_DescuentoDao;
import com.softca.soccer.dto.Reg_Descuento;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerReg_DescuentoImplement implements ManagerReg_Descuento {

    private Reg_DescuentoDao regDescuentoDao ;

    public ManagerReg_DescuentoImplement (Reg_DescuentoDao regDescuentoDao){
        this.regDescuentoDao = regDescuentoDao  ;
    }


    public void crear (Reg_Descuento regDescuento) throws Exception {

        Reg_Descuento regDescuentoDato = regDescuentoDao.selectById(regDescuento);

        if(regDescuentoDato==null){
            regDescuentoDao.insert ( regDescuento);
        }else{
            regDescuentoDao.update(regDescuento);
        }
    }

    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws Exception{

        Reg_Descuento reg_DescuentoDato = regDescuentoDao.selectById(regDescuento);
        return reg_DescuentoDato;
    }

    public List<Reg_Descuento> selectAll() throws Exception{
        List<Reg_Descuento> lista =  regDescuentoDao.selectAll();
        return lista;
    }

    public  void  delete(Reg_Descuento regDescuento ) throws Exception{
        if (regDescuento.getId()!=null){
            regDescuentoDao.delete( regDescuento);
        }

    }
}


