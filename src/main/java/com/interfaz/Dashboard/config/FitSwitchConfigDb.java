package com.interfaz.Dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


import javax.sql.DataSource;

@Configuration
public class FitSwitchConfigDb {
    // Configuración para la base de datos primaria
    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource primaryDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.17.1.6:1521:fitdvp");  // URL de la base primaria
        dataSource.setUsername("FITC");
        dataSource.setPassword("FITC");
        return dataSource;
    }

    // Configuración para JdbcTemplate de la base de datos primaria
    @Bean(name = "primaryJdbcTemplate")
    @Primary
    public JdbcTemplate primaryJdbcTemplate(DataSource primaryDataSource) {
        return new JdbcTemplate(primaryDataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usamos BCryptPasswordEncoder para la encriptación de contraseñas
        return new BCryptPasswordEncoder();
    }


}
