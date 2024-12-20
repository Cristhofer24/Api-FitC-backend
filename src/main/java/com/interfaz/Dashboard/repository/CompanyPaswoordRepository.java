package com.interfaz.Dashboard.repository;

import com.interfaz.Dashboard.model.CompanyPassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPaswoordRepository extends JpaRepository<CompanyPassword, String> {
}
