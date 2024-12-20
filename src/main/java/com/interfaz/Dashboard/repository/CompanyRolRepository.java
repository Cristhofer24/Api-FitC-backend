package com.interfaz.Dashboard.repository;

import com.interfaz.Dashboard.model.CompaniaROL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRolRepository extends JpaRepository<CompaniaROL,Integer> {
}
