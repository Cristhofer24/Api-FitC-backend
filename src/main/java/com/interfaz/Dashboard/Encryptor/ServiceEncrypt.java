package com.interfaz.Dashboard.Encryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ServiceEncrypt {
    private final ServiceDescrypt decryptService;

    @Autowired
    public ServiceEncrypt(ServiceDescrypt decryptService) {
        this.decryptService = decryptService;
    }

    public String encrypt(String phrase, String algorithm, String text) {
        ServiceDescrypt de = new ServiceDescrypt(phrase, algorithm);
        return de.encrypt(text);
    }

    public String decrypt(String phrase, String algorithm, String encryptedText) {
        ServiceDescrypt de = new ServiceDescrypt(phrase, algorithm);
        return de.decrypt(encryptedText);
    }
}
