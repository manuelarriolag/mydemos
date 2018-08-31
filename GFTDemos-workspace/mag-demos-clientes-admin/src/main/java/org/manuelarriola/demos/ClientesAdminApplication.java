package org.manuelarriola.demos;

import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ClientesAdminApplication {

	/**
	 * Objeto para generar bitácoras.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ClientesAdminApplication.class);

	
	/***
	 * Método principal de la aplicación
	 * 
	 * @param args
	 *            argumento del main
	 */
	public static void main(String[] args) {
		
	 	TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		ApplicationContext applicationContext = SpringApplication.run(ClientesAdminApplication.class, args);
		
		
		if (LOGGER.isDebugEnabled()) {
			// Mostrar los beans que estan activos
			for (String name : applicationContext.getBeanDefinitionNames()) {
				LOGGER.debug(name);
			}
		}
		
	}
	
	
	/***
	 * Método que se ejecuta para configuracion de swagger
	 * 
	 * @return un objeto Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				//.apis(RequestHandlerSelectors.basePackage("org.manuelarriola.demos.controllers"))
				.build()
				.pathMapping("/")
				.apiInfo(buildApiInfo());
	}
	
	/***
	 * Método invocado en la nueva API Swagger y contiene un objeto ApiInfoBuilder
	 * con encabezados de documentación swagger.
	 * <p>
	 * Podremos agregar información con título, descripción y
	 * versión del micro-servicio, etc
	 * 
	 * @return
	 */
	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder()
				.title("API REST Clientes")
				.description("Este aplicativo permite la administración del catálogo de clientes como una demostración de la arquitectura de micro-servicios.")
				.version("1.0.0")
				.build();
	}
	
	/***
	 * Bean de configuración de CORS para todas las peticiones
	 * posibles hacia el micro-servicio.
	 * 
	 * @return 
	 * 			el CorsFilter
	 */
	@Bean
	public CorsFilter corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(Boolean.TRUE);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("DELETE");
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}

}
