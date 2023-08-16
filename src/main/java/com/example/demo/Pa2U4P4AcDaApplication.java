package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.PropietarioService;

@SpringBootApplication
public class Pa2U4P4AcDaApplication implements CommandLineRunner {

	@Autowired
	private PropietarioService propietarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U4P4AcDaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Propietario propietario = new Propietario();
		propietario.setApellido("Cacuango");
		propietario.setCedula("12456789");
		propietario.setNombre("Mauricio");

		Propietario propietario2 = new Propietario();
		propietario2.setApellido("Andrade");
		propietario2.setCedula("7894561230");
		propietario2.setNombre("Dennisse");
		
	//	this.propietarioService.agregar(propietario2);
	//	this.propietarioService.agregar(propietario2);

	}

}
