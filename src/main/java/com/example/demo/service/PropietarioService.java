package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioService {

	public void agregar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public List<Propietario> buscarTodos();
	public void borrar(Integer id);
	
	public Propietario buscarPorId(Integer id);

}
