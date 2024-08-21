package com.softca.soccer.manager;

import com.softca.soccer.dao.AficionadoDao;
import com.softca.soccer.dto.Aficionado;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerAficionadoImplement implements ManagerAficionado {

    private AficionadoDao aficionadoDao;


    public ManagerAficionadoImplement(AficionadoDao aficionadoDao){
        this.aficionadoDao = aficionadoDao;
    }


    public void crear(Aficionado aficionado) throws Exception{
        Aficionado afiDato = aficionadoDao.selectById(aficionado);

        if(afiDato==null){
            aficionadoDao.insert(aficionado);
        }else{
            aficionadoDao.update(aficionado);
        }
    }
    public Aficionado selectById(Aficionado aficionado) throws Exception{
        Aficionado afiDato = aficionadoDao.selectById(aficionado);
        return afiDato;

    }
    public List<Aficionado> selectAll() throws Exception{
        List<Aficionado> lista =  aficionadoDao.selectAll();
        return lista;

    }
    public  void  delete(Aficionado aficionado ) throws Exception{
        if(aficionado.getId()!=null){
            aficionadoDao.delete(aficionado);
        }

    }
}
