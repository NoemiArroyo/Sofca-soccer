package com.softca.soccer.controller;


import com.softca.soccer.business.BusinessAdministrador;
import com.softca.soccer.dto.Administrador;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin/")

public class AdministradorController {

    private BusinessAdministrador businessAdministrador;

    public AdministradorController (BusinessAdministrador businessAdministrador){
        this.businessAdministrador=businessAdministrador;

    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Administrador>> saveOrUpdate(@RequestBody Administrador request) {
        log.debug ("REST request to saveOrUpdate administrador : {}", request);
        ResponseMessage message = null;
        try {
            this.businessAdministrador.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Administrador>> selectById(@RequestBody Administrador request) {
        log.debug("REST request to saveOrUpdate tarifa : {}", request);
        ResponseMessage message = null;
        try {
            Administrador adminfound= this.businessAdministrador.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", adminfound);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), null);
        }
        return ResponseEntity.ok(message);
    }


}
