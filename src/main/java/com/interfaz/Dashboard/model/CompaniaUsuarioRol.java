package com.interfaz.Dashboard.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TCOMPANIAUSUARIOSROLES")
public class CompaniaUsuarioRol {
    @Id
    @Column(name = "CUSUARIO")
    private String cUsuario;

}
