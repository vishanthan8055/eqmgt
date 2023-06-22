package com.dedalus.eqpmgmt.misc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

//@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		/*
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
				*/
				
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/test.*"), regex("/api/posts.*"), regex("/api/students.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Equimentmgmt API")
				.description("Equiment management API reference for developers")
				.termsOfServiceUrl("http://dedalus.com/equipmentmgmt.html")
				.license("dedalus tester License")
				.licenseUrl("eqmgmt@gmail.com").version("1.0").build();
	}
}
