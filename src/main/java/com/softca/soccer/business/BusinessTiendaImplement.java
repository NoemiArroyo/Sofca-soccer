package com.softca.soccer.business;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.manager.ManagerTienda;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BusinessTiendaImplement implements  BusinessTienda{

    private ManagerTienda managerTienda;

    //constructor *********************************************************************++
    public BusinessTiendaImplement(ManagerTienda managerTienda) {

        this.managerTienda = managerTienda;
    }


    public void registrar(Tiendas tiendas) throws Exception {
        managerTienda.crear(tiendas);
    }




    public Tiendas selectById(Tiendas tiendas ) throws Exception {
        Tiendas tnddata =null;
        tnddata= managerTienda.selectById(tiendas);
        return tnddata;
    }

    public List<Tiendas> selectAll() throws Exception{

            List<Tiendas> tnddata = null;

            tnddata= managerTienda.selectAll();

            return tnddata;
        }



}
