package br.univille.spring.boot.api.rest.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!test")
public class SwaggerConfig {
    
    protected String getTermsOfService() {
        return "Terms of Service";
    }

    protected String getLicenseUrl() {
        return "https://www.apache.org/licenses/LICENSE-2.0";
    }

    protected String getLicense() {
        return "UNIVILLE";
    }

	@Bean
	public Docket apis() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.univille.spring.boot.api.rest.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}
