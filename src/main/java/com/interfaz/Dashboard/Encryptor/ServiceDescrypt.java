package com.interfaz.Dashboard.Encryptor;


import org.springframework.stereotype.Service;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.spec.*;
import java.util.logging.*;

@Service
public class ServiceDescrypt {
    private static final Logger log = Logger.getLogger(ServiceDescrypt.class.getName());
    private Cipher cipher;
    private final SecretKey key;
    private final boolean encrypt;
    private final boolean webencrypt;
    private String algorithm = "DES";

    public ServiceDescrypt() {
        String phrase = "FIT-2008"; // Simulated configuration value
        this.encrypt = true;
        this.webencrypt = false;
        this.key = new SecretKeySpec(phrase.getBytes(), this.algorithm);
    }

    public ServiceDescrypt(String pPhrase) {
        String phrase = pPhrase;
        this.encrypt = true;
        this.webencrypt = true;
        this.key = new SecretKeySpec(phrase.getBytes(), this.algorithm);
    }

    public ServiceDescrypt(String pPhrase, String algorithm) {
        String phrase = pPhrase;
        this.encrypt = true;
        this.webencrypt = true;
        this.algorithm = algorithm;
        this.key = new SecretKeySpec(phrase.getBytes(), this.algorithm);
    }

    public String decrypt(String pText) {
        if (!this.encrypt) {
            return pText;
        }
        if (pText == null || pText.isEmpty()) {
            return pText;
        }

        try {
            init(Cipher.DECRYPT_MODE);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            OutputStream out = new CipherOutputStream(bout, this.cipher);
            out.write(hexStringToByteArray(pText));
            out.flush();
            out.close();
            return new String(bout.toByteArray());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Problemas al desencriptar un texto", e);
            return pText;
        }
    }

    public String encrypt(String pText) {
        if (!this.encrypt) {
            return pText;
        }
        if (pText == null || pText.isEmpty()) {
            return pText;
        }

        try {
            init(Cipher.ENCRYPT_MODE);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            OutputStream out = new CipherOutputStream(bout, this.cipher);
            out.write(pText.getBytes());
            out.flush();
            out.close();
            return byteArrayToHexString(bout.toByteArray());
        } catch (Exception e) {
            log.log(Level.SEVERE, "Problemas al encriptar una cadena", e);
            return pText;
        }
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

    private void init(int pType) throws Exception {
        byte[] iv = { -114, 18, 57, -100, 7, 114, 111, 90 };
        AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
        this.cipher = Cipher.getInstance(this.algorithm + "/CBC/PKCS5Padding");
        this.cipher.init(pType, this.key, paramSpec);
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
}
