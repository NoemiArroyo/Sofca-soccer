package com.softca.soccer.business;

import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.manager.ManagerAficionado;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BusinessAficionadoImplement  implements BusinesAficionado{

    private ManagerAficionado managerAficionado;


    //constructor *********************************************************************++
    public BusinessAficionadoImplement(ManagerAficionado managerAficionado) {
        this.managerAficionado = managerAficionado;
    }

    public void registrar(Aficionado aficionado) throws Exception{
        managerAficionado.crear(aficionado);
    }
    public Aficionado selectById(Aficionado aficionado ) throws Exception{
        Aficionado afndata =null;

        afndata= managerAficionado.selectById(aficionado);

        return afndata;
    }
    public List<Aficionado> selectAll() throws Exception{
        List<Aficionado> afndata =null;
        afndata= managerAficionado.selectAll();

        return afndata;

    }
}
