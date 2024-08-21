package com.softca.soccer.manager;


import com.softca.soccer.dto.Reg_Descuento;

import java.util.List;

public interface ManagerReg_Descuento {
    public void crear(Reg_Descuento regDescuento) throws Exception;
    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws Exception;
    public List<Reg_Descuento> selectAll() throws Exception;
    public  void  delete(Reg_Descuento regDescuento ) throws Exception;
}
