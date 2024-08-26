package com.softca.soccer.controller;

import com.softca.soccer.business.BusinesAficionado;
import com.softca.soccer.dto.Aficionado;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        log.debug("REST request to saveOrUpdate Aficionado : {}", request);
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
        log.debug("REST request to saveOrUpdate Aficionado : {}", request);
        ResponseMessage message = null;
        try {
            Aficionado aficionadofound= this.businesAficionado.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", aficionadofound);
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
            list = this.businesAficionado.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Aficionado>> deleteById(@RequestBody Aficionado request) {
        log.debug("REST request to deleteById tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businesAficionado.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }


}
