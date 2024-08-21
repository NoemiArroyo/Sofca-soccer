package com.softca.soccer.manager;

import com.softca.soccer.dao.TarifaDao;
import com.softca.soccer.dto.Tarifa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerTarifaImplement implements ManagerTarifa {

    private TarifaDao tarifaDao;


    public ManagerTarifaImplement(TarifaDao tarifaDao){
            this.tarifaDao = tarifaDao;
    }


    public void crear(Tarifa tarifa) throws Exception {

        Tarifa tarifaDato = tarifaDao.selectById(tarifa);

        if(tarifaDato==null){
            tarifaDao.insert(tarifa);
        }else{
            tarifaDao.update(tarifa);
        }
    }

    public Tarifa selectById(Tarifa tarifa) throws Exception{

        Tarifa tarifaDato = tarifaDao.selectById(tarifa);
        return tarifaDato;
    }

    public List<Tarifa> selectAll() throws Exception{
        List<Tarifa> lista =  tarifaDao.selectAll();
        return lista;
    }

    public  void  delete(Tarifa tarifa ) throws Exception{
        if(tarifa.getId()!=null){
            tarifaDao.delete(tarifa);
        }


    }
}
