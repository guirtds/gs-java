package com.example.beachcoins.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

// Classe padrao de config do swagger
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de gerenciamento do aplicativo BeachCoins")
                        .version("1.0")
                        .description("Esta é uma API RESTful para gerenciamento do aplicativo BeachCoins. " +
                                "Ela permite operações CRUD no sistema.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("InnovaStorm")
                                .url("http://www.fiap.com.br/support")
                                .email("suporte@fiap.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}