package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessReg_Descuento;
import com.softca.soccer.dto.Reg_Descuento;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/descuento/")

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


    @GetMapping("/selectAll")
    public ResponseEntity<ResponseMessage>  selectAll(){
        List<Map<String, Object>> list =null;
        ResponseMessage message = null;

        try {
            list = this.businessRegDescuento.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Reg_Descuento>> deleteById(@RequestBody Reg_Descuento request) {
        log.debug("REST request to deleteById tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessRegDescuento.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }


}

