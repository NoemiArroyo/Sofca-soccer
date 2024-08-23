package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessTransacciones;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.dto.Tiendas;
import com.softca.soccer.dto.Transacciones;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/transaccion/")
public class TransaccionController{

    private BusinessTransacciones businessTransacciones;

    public TransaccionController(BusinessTransacciones businessTransacciones) {
        this.businessTransacciones = businessTransacciones;
    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Transacciones>> saveOrUpdate(@RequestBody Transacciones request) {
        log.debug("REST request to saveOrUpdate tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTransacciones.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Transacciones>> selectById(@RequestBody Transacciones request) {
        log.debug("REST request to saveOrUpdate tarifa : {}", request);
        ResponseMessage message = null;
        try {
            Transacciones transafound= this.businessTransacciones.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", transafound);
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
            list = this.businessTransacciones.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Tarifa>> deleteById(@RequestBody Transacciones request) {
        log.debug("REST request to deleteById tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTransacciones.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

}
