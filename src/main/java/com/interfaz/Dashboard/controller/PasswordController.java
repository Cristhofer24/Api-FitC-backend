package com.interfaz.Dashboard.controller;

import com.interfaz.Dashboard.model.CompaniaROL;
import com.interfaz.Dashboard.model.CompanyPassword;
import com.interfaz.Dashboard.repository.CompanyPaswoordRepository;
import com.interfaz.Dashboard.repository.CompanyRolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/password")
public class PasswordController {
    private CompanyPaswoordRepository companyPaswoordRepository;

    public PasswordController(CompanyPaswoordRepository companyPaswoordRepository) {
        this.companyPaswoordRepository = companyPaswoordRepository;
    }
    @GetMapping
    public List<CompanyPassword> listarPassword() {
        return companyPaswoordRepository.findAll();
    }

}
