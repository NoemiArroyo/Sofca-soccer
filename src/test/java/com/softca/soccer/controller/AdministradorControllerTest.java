package com.softca.soccer.controller;

import com.softca.soccer.business.BusinessAdministrador;
import com.softca.soccer.dto.Administrador;
import com.softca.soccer.mensaje.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class AdministradorControllerTest {

    @Mock
    private BusinessAdministrador businessAdministrador;

    @InjectMocks
    private AdministradorController administradorController;

    private Administrador administrador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        administrador = new Administrador();
        administrador.setApellidos("Barrios Alvarez");
        administrador.setCedula("1069464849");
        administrador.setContra("sol33");
        administrador.setNit("2233");
        administrador.setId("asfsfd-safr-adsrew32-sfdsf4");
        administrador.setNombres("viivs damaris");
        administrador.setEmail("prueba@gmail.com");
    }

    @Test
    void sellectAll() {
        // Crear una lista de mapas de ejemplo para simular la respuesta de selectAll()
        Map<String, Object> administradorMap = Map.of("admin1", administrador);
        List<Map<String, Object>> administradores = Arrays.asList(administradorMap);

        // Configurar el mock para devolver esta lista
        when(businessAdministrador.selectAll()).thenReturn(administradores);

        assertNotNull(administradorController.selectAll());

    }


    @Test
    void selectById() {
        // Configurar el mock para devolver un administrador cuando se llama a selectById()
        when(businessAdministrador.selectById(administrador)).thenReturn(administrador);

        // Ejecutar el metodo selectById en el controlador
        ResponseEntity<ResponseMessage<Administrador>> response = administradorController.selectById(administrador);

        // Validar la respuesta
        assertNotNull(response);
        assertEquals(200, response.getBody().getCode()); // Verificar que el código de respuesta sea 200
        assertEquals(administrador, response.getBody().getData()); // Verificar que el administrador devuelto sea el mismo que se envió

    }

    @Test
    void saveOrUpdate() {

        // Configurar el mock para no hacer nada cuando se llama a registrar()
        doNothing().when(businessAdministrador).registrar(administrador);

        // Ejecutar el método saveOrUpdate en el controlador
        ResponseEntity<ResponseMessage<Administrador>> response = administradorController.saveOrUpdate(administrador);

        // Validar la respuesta
        assertNotNull(response); // Verificar que la respuesta no sea nula
        assertEquals(200, response.getBody().getCode()); // Verificar que el código de respuesta sea 200
        assertEquals("saveOrUpdate, process successful ", response.getBody().getMessage()); // Verificar el mensaje
        assertEquals(administrador, response.getBody().getData()); // Verificar que el administrador devuelto sea el mismo que se envió

    }

    @Test
    void deleteById() {

        // Configurar el mock para no hacer nada cuando se llama a delete()
        doNothing().when(businessAdministrador).delete(administrador);

        // Ejecutar el método deleteById en el controlador
        ResponseEntity<ResponseMessage<Administrador>> response = administradorController.deleteById(administrador);

        // Validar la respuesta
        assertNotNull(response); // Verificar que la respuesta no sea nula
        assertEquals(200, response.getBody().getCode()); // Verificar que el código de respuesta sea 200
        assertEquals("selectAll, process successful ", response.getBody().getMessage()); // Verificar el mensaje
        assertEquals(administrador, response.getBody().getData()); // Verificar que el administrador devuelto sea el mismo que se eliminó

    }
}