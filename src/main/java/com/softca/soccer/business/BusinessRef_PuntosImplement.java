package com.softca.soccer.business;


import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.manager.ManagerRef_Puntos;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BusinessRef_PuntosImplement implements BusinessRef_Puntos {

    private ManagerRef_Puntos managerRefPuntos;

    public  BusinessRef_PuntosImplement (ManagerRef_Puntos managerRefPuntos) {
        this.managerRefPuntos = managerRefPuntos;
    }

    public void registrar( Ref_Puntos refPuntos ) throws Exception {
        managerRefPuntos.crear(refPuntos );

    }


    public Ref_Puntos selectById( Ref_Puntos refPuntos) throws Exception{
        Ref_Puntos rpdata =null;

        rpdata= managerRefPuntos.selectById(refPuntos);

        return  rpdata;
    }

    public List< Ref_Puntos> selectAll() throws Exception{
        List< Ref_Puntos> rpdata =null;
        rpdata= managerRefPuntos.selectAll();

        return rpdata;
    }
}