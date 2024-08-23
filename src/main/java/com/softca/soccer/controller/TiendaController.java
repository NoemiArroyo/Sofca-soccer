package com.softca.soccer.controller;


import com.softca.soccer.business.BusinessTienda;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

        ResponseMessage message = null;
        try {
            Tiendas tiendafound= this.businessTienda.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", tiendafound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }



    @GetMapping("/selectAll")
    public ResponseEntity<ResponseMessage>  selectAll(){
        List<Map<String, Object>> list =null;
        ResponseMessage message = null;

        try {
            list = this.businessTienda.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Tarifa>> deleteById(@RequestBody Tiendas request) {
        log.debug("REST request to deleteById tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTienda.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }


}
