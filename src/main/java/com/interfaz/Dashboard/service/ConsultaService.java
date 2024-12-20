package com.interfaz.Dashboard.service;
import com.interfaz.Dashboard.model.AuthDTO;
import com.interfaz.Dashboard.model.CompaniaUsuarioRol;
import com.interfaz.Dashboard.model.ConsultaDTO;
import com.interfaz.Dashboard.repository.CompaniaUsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private CompaniaUsuarioRolRepository repository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<ConsultaDTO> findUsuarioRolPassword( ) {
        List<Object[]> results = repository.findUsuarioRolPassword();  // Llamada al repositorio
        List<ConsultaDTO> dtoList = new ArrayList<>();

        // Mapeo de los resultados crudos a DTOs
        for (Object[] result : results) {
            String cusuario = (String) result[0];
            String descripcion = (String) result[1];
            String password = (String) result[2];

            // Crear el DTO y añadirlo a la lista
            ConsultaDTO dto = new ConsultaDTO(cusuario, descripcion, password);
            dtoList.add(dto);
        }

        return dtoList;
    }


}