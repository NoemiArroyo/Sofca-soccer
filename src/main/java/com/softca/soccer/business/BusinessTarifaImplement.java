package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.manager.ManagerTarifa;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class BusinessTarifaImplement implements BusinessTarifa{


    private ManagerTarifa managerTarifa;

    //constructor *********************************************************************++
    public BusinessTarifaImplement(ManagerTarifa managerTarifa) {

        this.managerTarifa = managerTarifa;
    }

    public void registrar( Tarifa tarifa ) throws Exception {
         managerTarifa.crear(tarifa);

    }


    public Tarifa selectById(Tarifa tarifa ) throws Exception{
        Tarifa trfdata =null;

        trfdata= managerTarifa.selectById(tarifa);

        return trfdata;
    }

    public List<Tarifa> selectAll() throws Exception{
        List<Tarifa> trfdata =null;
         trfdata= managerTarifa.selectAll();

        return trfdata;
    }

    public void delete( Tarifa tarifa ) throws Exception {
        managerTarifa.delete(tarifa);

    }
}
