package com.softca.soccer.manager;

import com.softca.soccer.dao.Ref_PuntosDao;
import com.softca.soccer.dto.Ref_Puntos;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerRef_PuntosImplement implements ManagerRef_Puntos {

    private Ref_PuntosDao refPuntosDao;

    public ManagerRef_PuntosImplement (Ref_PuntosDao refPuntosDao) {
        this.refPuntosDao = refPuntosDao;
    }

    public void crear(Ref_Puntos refPuntos) throws Exception {

        Ref_Puntos ref_puntosDato = refPuntosDao.selectById(refPuntos);

        if(ref_puntosDato==null){
            refPuntosDao.insert (refPuntos);
        }else{
            refPuntosDao.update(refPuntos);
        }
    }

    public Ref_Puntos selectById(Ref_Puntos refPuntos) throws Exception{

        Ref_Puntos ref_puntosDato = refPuntosDao.selectById(refPuntos);
        return ref_puntosDato;
    }

    public List<Ref_Puntos> selectAll() throws Exception{
        List<Ref_Puntos> lista =  refPuntosDao.selectAll();
        return lista;
    }

    public  void  delete (Ref_Puntos refPuntos) throws Exception{
        if(refPuntos.getId()!=null){
            refPuntosDao.delete(refPuntos);
        }


    }
}

