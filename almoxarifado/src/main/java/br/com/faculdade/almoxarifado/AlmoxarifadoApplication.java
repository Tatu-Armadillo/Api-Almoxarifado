package br.com.faculdade.almoxarifado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class AlmoxarifadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmoxarifadoApplication.class, args);
	}

}
