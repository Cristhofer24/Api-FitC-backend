package com.interfaz.Dashboard.model;

public class AuthDTO {
    private  String cUsuario ;
    private  String password;
    private String role;

    public AuthDTO(String cUsuario, String password, String role) {
        this.cUsuario = cUsuario;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
