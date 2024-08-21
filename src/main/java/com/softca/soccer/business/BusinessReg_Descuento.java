package com.softca.soccer.business;



import com.softca.soccer.dto.Reg_Descuento;

import java.util.List;

public interface BusinessReg_Descuento {
    public void registrar( Reg_Descuento regDescuento ) throws Exception;
    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws Exception;
    public List<Reg_Descuento> selectAll() throws Exception;
}
