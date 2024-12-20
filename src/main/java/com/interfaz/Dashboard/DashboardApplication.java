package com.interfaz.Dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@ComponentScan(basePackages = "com.interfaz.Dashboard.config")
@SpringBootApplication(scanBasePackages = "com.interfaz.Dashboard")
@EnableJpaRepositories(basePackages = "com.interfaz.Dashboard.repository")
@EnableWebMvc
public class DashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Asegúrate de que estas configuraciones se ajusten a tu necesidad
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:4200") // Origen de tu aplicación Angular
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
						.allowedHeaders("*") // Todos los encabezados permitidos
						.allowCredentials(true); // Habilitar credenciales (cookies, cabeceras de autorización, etc.)
			}
		};
	}
}







