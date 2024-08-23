package com.softca.soccer.business;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import java.util.List;
import java.util.Map;


public interface BusinessTienda {

    public void registrar( Tiendas tienda ) throws Exception;
    public Tiendas selectById(Tiendas tienda ) throws Exception;
    public List<Map<String, Object>> selectAll() throws Exception;
    public void delete( Tiendas tienda ) throws Exception;
}
