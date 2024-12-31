package com.interfaz.Dashboard.service;
import com.interfaz.Dashboard.Encryptor.ServiceDescrypt;
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
    private AuthRepository authRepository;

    private final ServiceDescrypt decrypt = new ServiceDescrypt("FIT-2008", "DES");

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

        String encryptedPassword = decrypt.encrypt(authDTO.getPassword());
        // Comparar las contraseñas en texto claro
        return encryptedPassword.trim().equals(storedPassword.trim());
    }

    public String getUserRole(String cUsuario) {
        // Consultar la base de datos para obtener el rol basado en el nombre de usuario
        List<Object[]> result = authRepository.findUsuarioRolPassword(cUsuario);

        if (result.isEmpty()) {
            return null; // No se encontró el usuario
        }

        // Extraer el rol del resultado de la consulta
        String role = (String) result.get(0)[1]; // Suponiendo que el índice 1 es el rol
        return role;
    }



}
