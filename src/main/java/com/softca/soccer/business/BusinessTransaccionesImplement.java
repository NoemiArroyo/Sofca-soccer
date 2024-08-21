package com.softca.soccer.business;

import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.manager.ManagerTransacciones;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional

public class BusinessTransaccionesImplement implements  BusinessTransacciones{

    private ManagerTransacciones managerTransacciones;


    //constructor *********************************************************************++
    public BusinessTransaccionesImplement( ManagerTransacciones managerTransacciones) {
        this.managerTransacciones = managerTransacciones;
    }

    public void registrar(Transacciones transacciones ) throws Exception{
        managerTransacciones.crear(transacciones);

    }


    public Transacciones selectById(Transacciones transacciones ) throws Exception{
        Transacciones trsdata =null;

        trsdata= managerTransacciones.selectById(transacciones);

        return trsdata;

    }


    public List<Transacciones> selectAll() throws Exception{
        List<Transacciones> trsdata =null;
        trsdata= managerTransacciones.selectAll();

        return trsdata;

    }


}
