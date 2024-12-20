package com.interfaz.Dashboard.service;
import com.interfaz.Dashboard.model.AuthDTO;
import com.interfaz.Dashboard.model.CompaniaUsuarioRol;
import com.interfaz.Dashboard.repository.AuthRepository;
import com.interfaz.Dashboard.repository.CompaniaUsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;  // Acceso al repositorio donde se guarda la información del usuario y contraseña

    // Método para autenticar al usuario
    public boolean authenticateUser(AuthDTO authDTO) {
        // Ejecuta la consulta para obtener el nombre de usuario y la contraseña almacenada
        List<Object[]> result = authRepository.findUsuarioRolPassword(authDTO.getcUsuario());

        // Verificar si la consulta devuelve algún resultado
        if (result.isEmpty()) {
            return false;  // No se encontró el usuario
        }

        // Extraer el nombre de usuario y la contraseña en texto claro de la consulta
        String storedUsername = (String) result.get(0)[0];  // Nombre de usuario almacenado
        String storedPassword = (String) result.get(0)[2];  // Contraseña almacenada (en texto claro)

        // Comparar el nombre de usuario ingresado con el almacenado
        if (!authDTO.getcUsuario().equals(storedUsername)) {
            return false;  // El nombre de usuario no coincide
        }

        // Comparar las contraseñas en texto claro
        return authDTO.getPassword().trim().equals(storedPassword.trim());
    }



}
