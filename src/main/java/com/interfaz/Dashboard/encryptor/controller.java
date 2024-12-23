package com.interfaz.Dashboard.encryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/encryption")
public class controller {
    @Autowired
    private Encriptor encriptor;

    // Endpoint para probar la encriptación
    @PostMapping("/encrypt")
    public String encryptText(@RequestBody String text) {
        return encriptor.encrypt(text);
    }

    // Endpoint para probar el desencriptado
    @PostMapping("/decrypt")
    public String decryptText(@RequestBody String text) {
        return encriptor.decrypt(text);
    }

}
