package com.interfaz.Dashboard.encryptor;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.spec.AlgorithmParameterSpec;

@Service
public class Encriptor implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(Encriptor.class);

    private static final long serialVersionUID = 1L;

    private Cipher cipher;
    private SecretKey key;

    @Value("${security.phrase}")
    private String phrase;

    @Value("${security.encrypt:true}")
    private boolean encrypt;

    @Value("${security.webencrypt:false}")
    private boolean webencrypt;

    @Value("${security.algorithm:DES}")
    private String algorithm;

    @PostConstruct
    public void init() {
        try {
            // Inicializa la clave usando el valor de 'phrase' inyectado
            this.key = new SecretKeySpec(phrase.getBytes(), algorithm);
        } catch (Exception e) {
            log.error("Error al inicializar la clave de cifrado", e);
        }
    }

    public String decrypt(String pText) {
        if (!encrypt) {
            return pText;
        }

        if (pText == null || pText.isEmpty()) {
            return pText;
        }

        try {
            initCipher(Cipher.DECRYPT_MODE);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            OutputStream out = new CipherOutputStream(bout, cipher);
            out.write(hexStringToByteArray(pText));
            out.flush();
            out.close();
            return new String(bout.toByteArray());
        } catch (Exception e) {
            log.error("Problemas al desencriptar un texto", e);
            return pText;
        }
    }

    public String encrypt(String pText) {
        if (!encrypt) {
            return pText;
        }

        if (pText == null || pText.isEmpty()) {
            return pText;
        }

        try {
            initCipher(Cipher.ENCRYPT_MODE);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            OutputStream out = new CipherOutputStream(bout, cipher);
            out.write(pText.getBytes());
            out.flush();
            out.close();
            return byteArrayToHexString(bout.toByteArray());
        } catch (Exception e) {
            log.error("Problemas al encriptar una cadena", e);
            return pText;
        }
    }

    private void initCipher(int mode) throws Exception {
        byte[] iv = { -114, 18, 57, -100, 7, 114, 111, 90 }; // IV constante
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
        cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding");
        cipher.init(mode, key, paramSpec);
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (byte element : b) {
            int v = element & 0xFF;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] hexStringToByteArray(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < b.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(s.substring(index, index + 2), 16);
            b[i] = (byte) v;
        }
        return b;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public boolean isWebencrypt() {
        return webencrypt;
    }
}
