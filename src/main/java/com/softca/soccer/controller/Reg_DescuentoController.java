package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessReg_Descuento;
import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/descuento /")

     public class Reg_DescuentoController {


    private BusinessReg_Descuento businessRegDescuento;

    public Reg_DescuentoController (BusinessReg_Descuento businessRegDescuento){
        this.businessRegDescuento=businessRegDescuento;

    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Reg_Descuento>> saveOrUpdate(@RequestBody Reg_Descuento request) {
        log.debug("REST request to saveOrUpdate reg_descuento : {}", request);
        ResponseMessage message = null;
        try {
            this.businessRegDescuento.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Reg_Descuento>> selectById(@RequestBody Reg_Descuento request) {
        log.debug("REST request to saveOrUpdate reg_descuento : {}", request);
        ResponseMessage message = null;
        try {
            Reg_Descuento rdfound= this.businessRegDescuento.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", rdfound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

}

