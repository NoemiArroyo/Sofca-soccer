package com.softca.soccer.manager;
import com.softca.soccer.dao.TiendaDao;
import org.springframework.stereotype.Component;
import com.softca.soccer.dto.Tiendas;
import java.util.List;
import java.util.Map;


@Component
public class ManagerTiendaImplement implements ManagerTienda{

    private TiendaDao tiendasDao;


    public ManagerTiendaImplement(TiendaDao tiendaDao) {
        this.tiendasDao = tiendaDao;
    }


    public void crear(Tiendas tienda) throws Exception {

        Tiendas tiendaDato = tiendasDao.selectById(tienda);

        if(tiendaDato==null){
            tiendasDao.insert(tienda);
        }else{
            tiendasDao.update(tienda);
        }
    }

    public Tiendas selectById(Tiendas tienda) throws Exception{
        Tiendas tiendaDato = tiendasDao.selectById(tienda);
        return tiendaDato;
    }

    public List<Map<String, Object>> selectAll() throws Exception{
        return this.tiendasDao.selectAll();
    }

    public  void  delete(Tiendas tiendas ) throws Exception{
        if(tiendas.getId()!=null){
            tiendasDao.delete(tiendas);
        }


    }
}
