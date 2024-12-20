package com.interfaz.Dashboard.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TUSUARIOPASSWORD")
public class CompanyPassword {

    @Id
    @Column(name = "CUSUARIO")
    private String cUser;
    @Column(name = "PASSWORD")
    private String password;
}
