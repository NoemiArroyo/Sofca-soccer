package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessTarifa;
import com.softca.soccer.dto.Tarifa;
import com.softca.soccer.mensaje.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable final Tarifa id) throws Exception {
        log.debug("deleteTransaction queried with id: {}", id); //$NON-NLS-1$

        // Asumiendo que tienes un método en tu servicio que verifica si la transacción existe
        Tarifa exists = this.businessTarifa.selectById(id);

        if (exists!=null) {
            try {
                this.businessTarifa.delete(id);
                log.debug("Transaction with id: {} deleted successfully.", id); //$NON-NLS-1$
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception ex) {
                log.error("Error deleting transaction with id: {}", id, ex); //$NON-NLS-1$
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            log.debug("Transaction with id: {} does NOT exist.", id); //$NON-NLS-1$
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
