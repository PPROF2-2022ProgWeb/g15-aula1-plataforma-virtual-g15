package com.saberconectar.sc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

import static com.saberconectar.sc.config.infoSwagger.*;

@Configuration
//@EnableSwagger2
//@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                TITLE,
                DESCRIPTION,
                VERSION,
                TERMS_OF_SERVICE,
                new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL),
                LICENCE, LICENCE_URL, Collections.emptyList());
    }

    private ApiKey apiKey(){
        return new ApiKey(JWT, AUTHORIZATION_HEADER, HEADER);
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        final String SCOPE = "global";
        final String DESCRIPTION = "accessEverything";
        AuthorizationScope authorizationScope = new AuthorizationScope(SCOPE,DESCRIPTION);
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference(JWT, authorizationScopes));
    }
}