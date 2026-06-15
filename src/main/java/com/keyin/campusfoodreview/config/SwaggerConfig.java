package com.keyin.campusfoodreview.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Campus Food Review REST API")
                        .version("0.1.0")
                        .description("REST API for managing campuses, restaurants, and food reviews.")
                        .contact(new Contact()
                                .email("tryhardman83@gmail.com")));
    }
}
