package com.softca.soccer.manager;

import com.softca.soccer.dao.TransaccionDao;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ManagerTransaccionesImplement  implements ManagerTransacciones{

    private TransaccionDao transaccionDao;

    public ManagerTransaccionesImplement(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
    }

    public void crear(Transacciones transacciones) throws Exception{

        Transacciones trsDato = transaccionDao.selectById(transacciones);

        if(trsDato==null){
            transaccionDao.insert(transacciones);
        }else{
            transaccionDao.update(transacciones);
        }

    }
    public Transacciones selectById(Transacciones transacciones) throws Exception{
        Transacciones trsDato = transaccionDao.selectById(transacciones);
        return trsDato;

    }
    public List<Transacciones> selectAll() throws Exception{

        List<Transacciones> lista =  transaccionDao.selectAll();
        return lista;

    }
    public  void  delete(Transacciones transacciones ) throws Exception{
        if(transacciones.getId()!=null){
            transaccionDao.delete(transacciones);
        }

    }
}
