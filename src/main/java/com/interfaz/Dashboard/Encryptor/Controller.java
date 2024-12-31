package com.interfaz.Dashboard.Encryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crypto")
public class Controller {
    private final ServiceEncrypt crypto;

    @Autowired
    public Controller(ServiceEncrypt crypto) {
        this.crypto = crypto;
    }

    // Modificar para recibir los datos en el cuerpo de la solicitud como un JSON
    @PostMapping("/encrypt")
    public String encrypt(@RequestBody EncryptionRequest request) {
        return crypto.encrypt(request.getPhrase(), request.getAlgorithm(), request.getText());
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody EncryptionRequest request) {
        return crypto.decrypt(request.getPhrase(), request.getAlgorithm(), request.getEncryptedText());
    }
}
