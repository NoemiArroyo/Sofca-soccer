package com.softca.soccer.controller;


import com.softca.soccer.business.BusinessTienda;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/tienda/")

public class TiendaController {

    private BusinessTienda businessTienda;

    public TiendaController(BusinessTienda businessTienda){
        this.businessTienda=businessTienda;

    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Tiendas>> saveOrUpdate(@RequestBody Tiendas request) {
        log.debug("REST request to saveOrUpdate una tienda : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTienda.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Tiendas>> selectById(@RequestBody Tiendas request) {
        log.debug("REST request to saveOrUpdate tienda : {}", request);
        ResponseMessage message = null;
        try {
            Tiendas tiendafound= this.businessTienda.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", tiendafound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

}
