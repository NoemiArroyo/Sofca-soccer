package com.softca.soccer.manager;


import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.exception.ManageException;

import java.util.List;
import java.util.Map;

public interface ManagerReg_Descuento {
    public void crear(Reg_Descuento regDescuento) throws Exception;
    public Reg_Descuento selectById(Reg_Descuento regDescuento) throws Exception;
    public List<Map<String, Object>> selectAll() throws ManageException;
    public  void  delete(Reg_Descuento regDescuento ) throws Exception;
}
