package com.interfaz.Dashboard.controller;

import com.interfaz.Dashboard.model.AuthDTO;
import com.interfaz.Dashboard.repository.AuthRepository;
import com.interfaz.Dashboard.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST })
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {
        // Verificamos que el objeto authDTO no esté vacío o con valores nulos
        if (authDTO.getcUsuario() == null || authDTO.getPassword() == null) {
            // Si el nombre de usuario o la contraseña son nulos, retornamos un error 401
            return ResponseEntity.status(401).body("Datos incompletos o nulos");
        }

        // Llamamos al servicio de autenticación para verificar las credenciales
        boolean isAuthenticated = authService.authenticateUser(authDTO);

        if (isAuthenticated) {
            // Aquí puedes devolver un JWT si decides implementarlo
            return ResponseEntity.ok("Login exitoso");
        } else {
            // Si las credenciales no son correctas, devolvemos un error 401
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }



}
