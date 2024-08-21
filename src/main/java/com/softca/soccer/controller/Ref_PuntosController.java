package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessRef_Puntos;
import com.softca.soccer.dto.Ref_Puntos;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/puntosRef /")

public class Ref_PuntosController {

    private BusinessRef_Puntos businessRefPuntos;

    public Ref_PuntosController (BusinessRef_Puntos businessRefPuntos){
        this.businessRefPuntos = businessRefPuntos;

    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Ref_Puntos>> saveOrUpdate(@RequestBody Ref_Puntos request) {

        log.debug ("REST request to saveOrUpdate ref_puntos : {}", request);
        ResponseMessage message = null;
        try {
            this.businessRefPuntos.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Ref_Puntos>> selectById(@RequestBody Ref_Puntos request) {
        log.debug("REST request to saveOrUpdate ref_puntos : {}", request);
        ResponseMessage message = null;
        try {
            Ref_Puntos refPuntosfound= this.businessRefPuntos.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", refPuntosfound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }

}

