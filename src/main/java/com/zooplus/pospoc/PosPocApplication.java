package com.zooplus.pospoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Zooplus POS",
				description = "REST API for Zooplus POS",
				contact = @Contact(
						name = "Sarath Raghavan",
						email = "sarathnambradath@gmail.com"
				),
				license = @License(
						url = "https://github.com/thombergs/code-examples/blob/master/LICENSE")),
		servers = @Server(url = "http://localhost:8080")
)
public class PosPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosPocApplication.class, args);
	}

}
