package com.softca.soccer.business;



import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.exception.BusinessException;

import java.util.List;
import java.util.Map;

public interface BusinessReg_Descuento {
    public void registrar( Reg_Descuento regDescuento ) throws BusinessException;
    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws BusinessException;
    public List<Map<String, Object>> selectAll() throws BusinessException;
    public void delete( Reg_Descuento regDescuento ) throws BusinessException;

}
