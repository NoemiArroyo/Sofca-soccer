package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessTarifa;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/tarifas/")
public class TarifaController {

    private BusinessTarifa businessTarifa;

    public TarifaController(BusinessTarifa businessTarifa){
        this.businessTarifa=businessTarifa;

    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<Tarifa>> saveOrUpdate(@RequestBody Tarifa request) {
        log.debug("REST request to saveOrUpdate tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTarifa.registrar(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        } catch (Exception ex) {
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping({"/selectById"})
    public ResponseEntity<ResponseMessage<Tarifa>> selectById(@RequestBody Tarifa request) {
        log.debug("REST request to saveOrUpdate tarifa : {}", request);
        ResponseMessage message = null;
        try {
            Tarifa tarifafound= this.businessTarifa.selectById(request);
            message = new ResponseMessage<>(200, "selectById, process successful ", tarifafound);
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
            list = this.businessTarifa.selectAll();
            message = new ResponseMessage<>(200, "selectAll, process successful ", list);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseMessage<Tarifa>> deleteById(@RequestBody Tarifa request) {
        log.debug("REST request to deleteById tarifa : {}", request);
        ResponseMessage message = null;
        try {
            this.businessTarifa.delete(request);
            message = new ResponseMessage<>(200, "selectAll, process successful ", request);

        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), null);

        }
        return ResponseEntity.ok(message);
    }

}





