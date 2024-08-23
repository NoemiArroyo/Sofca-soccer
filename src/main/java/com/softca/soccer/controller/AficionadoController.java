package com.softca.soccer.controller;

import com.softca.soccer.business.BusinesAficionado;
import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/aficionado/")
public class AficionadoController {

    private BusinesAficionado businesAficionado;

    public AficionadoController(BusinesAficionado businesAficionado){
        this.businesAficionado=businesAficionado;
    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Aficionado>> saveOrUpdate(@RequestBody Aficionado request) {

        ResponseMessage message = null;
        try {
            this.businesAficionado.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful Aficionado", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Aficionado>> selectById(@RequestBody Aficionado request) {

        ResponseMessage message = null;
        try {
            Aficionado aficionadofound= this.businesAficionado.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", aficionadofound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }


}
