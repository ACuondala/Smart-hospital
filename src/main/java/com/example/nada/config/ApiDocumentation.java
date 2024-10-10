package com.example.nada.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Smart-Hospital",
                version = "1.0.0",
                description = "All hospital services in one software",
                contact = @Contact(
                        name=" Anderson And Celso",
                        email="acuondala@gmail.com and celsorocha@gmail.com"
                )


        )
)
public class ApiDocumentation {
}
