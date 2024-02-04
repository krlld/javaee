package com.example.boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Picture management api",
                description = "Picture management system", version = "1.0.0",
                contact = @Contact(
                        name = "Kirill Dikun",
                        email = "exampleemail@gmail.com"
                )
        )
)
public class OpenApiConfig {

}
