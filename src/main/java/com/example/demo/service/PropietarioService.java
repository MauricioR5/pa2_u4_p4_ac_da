package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioService {

	public void agregar(Propietario propietario);
	public void modificar(Propietario propietario);
	public List<Propietario> buscarTodos();
	public void borrar(Integer id);
}
