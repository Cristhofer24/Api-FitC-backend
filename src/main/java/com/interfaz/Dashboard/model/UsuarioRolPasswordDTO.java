package com.interfaz.Dashboard.model;

public class UsuarioRolPasswordDTO {
    private String usuario;
    private String descripcion;
    private String password;

    public UsuarioRolPasswordDTO(String usuario, String descripcion, String password) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
