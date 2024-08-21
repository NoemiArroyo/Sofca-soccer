package com.softca.soccer.business;
import com.softca.soccer.dto.Tiendas;
import java.util.List;


public interface BusinessTienda {

    public void registrar( Tiendas tienda ) throws Exception;
    public Tiendas selectById(Tiendas tienda ) throws Exception;
    public List<Tiendas> selectAll() throws Exception;
}
