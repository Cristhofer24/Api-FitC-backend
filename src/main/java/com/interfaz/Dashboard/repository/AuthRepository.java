package com.interfaz.Dashboard.repository;

import com.interfaz.Dashboard.model.CompaniaUsuarioRol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<CompaniaUsuarioRol, String> {
    @Query(value = "SELECT tcur0.CUSUARIO, tr0.DESCRIPCION, tup0.PASSWORD " +
            "FROM TCOMPANIAUSUARIOSROLES tcur0 " +
            "JOIN TROLES tr0 " +
            "ON tr0.FHASTA = FNCFHASTA() " +
            "AND tr0.CROL = tcur0.CROL " +
            "JOIN TUSUARIOPASSWORD tup0 " +
            "ON tup0.FHASTA = FNCFHASTA() " +
            "AND tup0.CUSUARIO = tcur0.CUSUARIO " +
            "WHERE tup0.CUSUARIO = :cUsuario", nativeQuery = true)
    List<Object[]> findUsuarioRolPassword(@Param("cUsuario") String cUsuario);


}