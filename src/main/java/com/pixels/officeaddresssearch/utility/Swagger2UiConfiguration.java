package com.pixels.officeaddresssearch.utility;

import org.springframework.cglib.core.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class Swagger2UiConfiguration {

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
		.title("Location API ")
		.description("Location search API Documentation")
		.version("1.0.0")
		.build();
		}

		@Bean
		public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(this.apiInfo())
		.enable(true)
		.select()
		.paths(PathSelectors.any())
		.build();
		}
	
}
