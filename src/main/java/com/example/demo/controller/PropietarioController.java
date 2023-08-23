package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
	 
	@Autowired
	private IPropietarioService propietarioService;
	
	//http://localhost:8080/concensionario/propietarios/buscar
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.propietarioService.buscarLista();
		modelo.addAttribute("propietarios",lista);
		return "vistaListaPropietarios";
	}
	
	//http://localhost:8080/concensionario/propietarios/buscarPorID/8
	@GetMapping("/buscarPorID/{idPropietario}") //path variable: se envia en el path y es variable
	public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {
		Propietario prop = this.propietarioService.encontrar(id);
		model.addAttribute("propietario", prop);
		return "vistaPropietarios";
	}
	
	//http://localhost:8080/concensionario/propietarios/actualizar/8
	@GetMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario) { //id y objeto a actualizar
		this.propietarioService.modificar(propietario);
		return "redirect:/propietarios/buscar";
	}
	
	//http://localhost:8080/concensionario/propietarios/borrar/1
	@DeleteMapping("/borrar/{idPropietario}")
	public String eliminarPorID(@PathVariable("idPropietario") Integer id) {
		this.propietarioService.borrar(id);
		return "redirect:/propietarios/buscar";
	}
	
	@PostMapping("/guardar")
	public String insertarPropietario(Propietario propietario) {
		this.propietarioService.agregar(propietario);
		return "redirect:/propietarios/buscar";
	}
	
	
	//metodo de pagina de redireccionamiento
	@GetMapping("/nuevo")
	public String paginaNuevoPropietario(Propietario propietario) {
		return "vistaNuevoPropietario";
	}
	
}


