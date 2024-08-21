package com.softca.soccer.business;


import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.manager.ManagerReg_Descuento;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class BusinessReg_DescuentoImplement implements BusinessReg_Descuento {

    private ManagerReg_Descuento managerRegDescuento ;


    public BusinessReg_DescuentoImplement (ManagerReg_Descuento managerRegDescuento) {
        this.managerRegDescuento = managerRegDescuento;

    }
    public void registrar( Reg_Descuento regDescuento ) throws Exception {
        managerRegDescuento.crear(regDescuento);

    }


    public  Reg_Descuento selectById(Reg_Descuento regDescuento ) throws Exception{
        Reg_Descuento rd =null;

        rd= managerRegDescuento.selectById(regDescuento);

        return rd;
    }

    public List<Reg_Descuento> selectAll() throws Exception{
        List<Reg_Descuento> rd =null;
        rd= managerRegDescuento.selectAll();

        return rd;
    }
}


