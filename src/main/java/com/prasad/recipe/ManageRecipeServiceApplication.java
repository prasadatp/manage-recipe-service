package com.prasad.recipe;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class ManageRecipeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageRecipeServiceApplication.class, args);
	}
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.prasad"))
				.build().apiInfo(appInfo());
	}

	private ApiInfo appInfo() {
		return new ApiInfo("Book Info Service", "POC for ABN", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Prasad Nakkalakunta", "http://prsads", "prasd.nakkalakunta@capgemini.com"),
				"License Free", "mylecense.com", Collections.emptyList());

	}

}
