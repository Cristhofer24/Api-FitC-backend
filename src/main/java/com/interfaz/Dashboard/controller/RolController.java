package com.interfaz.Dashboard.controller;

import com.interfaz.Dashboard.model.CompaniaROL;
import com.interfaz.Dashboard.model.CompaniaUsuarioRol;
import com.interfaz.Dashboard.repository.CompanyRolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    private CompanyRolRepository companyRolRepository;

    public RolController(CompanyRolRepository companyRolRepository) {
        this.companyRolRepository = companyRolRepository;
    }
    @GetMapping
    public List<CompaniaROL> listarRoles() {
        return companyRolRepository.findAll();
    }
}
