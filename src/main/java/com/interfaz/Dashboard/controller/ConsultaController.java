package com.interfaz.Dashboard.controller;

import com.interfaz.Dashboard.model.ConsultaDTO;
import com.interfaz.Dashboard.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @GetMapping
    public List<ConsultaDTO> obtenerUsuariosConRolesYContraseñas() {
        return consultaService.findUsuarioRolPassword();  // Llamar al servicio
    }
}
