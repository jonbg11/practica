package com.exam.practice.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Product api.
	 *
	 * @return Constructor de la interfaz primaria SWAGGER.
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error"))).build().apiInfo(metaData());
	}

	/**
	 * Meta data.
	 *
	 * @return Información general del API.
	 */
	@SuppressWarnings("rawtypes")
	private static ApiInfo metaData() {
		return new ApiInfo("Practica JBG",
				"Aplicación java con microservicios",
				"1.0",
				"URL de Terminos de servicio",
				new Contact("GNP",
						"https://github.com/jonbg11/practica",
						""),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0",
				Collections.emptyList());
	}

}
