package com.softca.soccer.dao;
import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.exception.DaoException;

import java.util.List;
import java.util.Map;

public interface Reg_DescuentoDao {
    public void insert(Reg_Descuento regDescuento) throws DaoException;
    public void update(Reg_Descuento regDescuento) throws DaoException;
    public void delete(Reg_Descuento regDescuento) throws DaoException;
    public Reg_Descuento selectById(Reg_Descuento regDescuento);
    public List<Map<String, Object>> selectAll() throws DaoException;
}

