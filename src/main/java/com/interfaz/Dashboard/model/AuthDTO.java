package com.interfaz.Dashboard.model;

public class AuthDTO {
    private  String cUsuario ;
    private  String password;

    public AuthDTO(String cUsuario, String password) {
        this.cUsuario = cUsuario;
        this.password = password;
    }

    public String getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
