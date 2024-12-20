package com.interfaz.Dashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TROLES")
public class CompaniaROL {
    @Id
    @Column(name = "CROL")
    private Integer cRol;
    @Column(name = "DESCRIPCION")
    private String DESCRIPCION;
}
