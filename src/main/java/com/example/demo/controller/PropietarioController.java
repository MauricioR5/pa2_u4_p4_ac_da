package com.example.demo.controller;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.PropietarioService;

 

@Controller

@RequestMapping("/propietarios")//en plural por buena practica

public class PropietarioController {


    @Autowired

    private PropietarioService propietarioService;


    //http://localhost:8080/concensionario/propietarios/buscar

    @GetMapping("/buscar")

    public String buscarTodos(Model modelo) {

        List<Propietario> lista = this.propietarioService.buscarTodos();

        modelo.addAttribute("propietarios",lista);

        return "vistaListaPropietarios";

    }


    //http://localhost:8080/concensionario/propietarios/buscarPorID/8

    @GetMapping("/buscarPorID/{idPropietario}") //path variable: se envia en el path y es variable

    public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {

        Propietario prop = this.propietarioService.buscarPorId(id);

        model.addAttribute("propietario", prop);

        return "vistaPropietario";

    }
    @PutMapping("/actualizar/{idPropietario}")
    public String actualizarPropietario(@PathVariable("idPropietario") Integer id, Propietario propietario ) {
    	this.propietarioService.actualizar(propietario);
    	return "redirect:/propietarios/buscar";
    }


}
