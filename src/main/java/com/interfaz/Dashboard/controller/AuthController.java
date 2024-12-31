package com.interfaz.Dashboard.controller;

import com.interfaz.Dashboard.Encryptor.ServiceDescrypt;
import com.interfaz.Dashboard.model.AuthDTO;
import com.interfaz.Dashboard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST })
public class AuthController {

    @Autowired
    private AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {

        if (authDTO.getcUsuario() == null || authDTO.getPassword() == null) {

            return ResponseEntity.status(401).body("Datos incompletos o nulos");
        }


        boolean isAuthenticated = authService.authenticateUser(authDTO);
        String role = authService.getUserRole(authDTO.getcUsuario());
 ;

        if (isAuthenticated) {

            return ResponseEntity.ok(new HashMap() {{put("message", "Login exitoso");
                put("role", role);
            }});

        } else {

            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }



}
