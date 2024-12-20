package com.interfaz.Dashboard.controller;


import com.interfaz.Dashboard.model.CompaniaUsuarioRol;
import com.interfaz.Dashboard.repository.CompaniaUsuarioRolRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios-roles")
public class UsuarioRolController {

    private final CompaniaUsuarioRolRepository companiaUsuarioRolRepository;

    public UsuarioRolController(CompaniaUsuarioRolRepository companiaUsuarioRolRepository) {
        this.companiaUsuarioRolRepository = companiaUsuarioRolRepository;
    }

    @GetMapping
    public List<CompaniaUsuarioRol> listarUsuarios() {
        return companiaUsuarioRolRepository.findAll();
    }
}





