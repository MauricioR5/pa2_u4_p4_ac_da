package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface PropietarioRepository {
	public void insertar(Propietario propietario);
	public void actualizar(Propietario propietario);
	public void eliminar(Integer id);
	
	public List<Propietario> buscarTodos();
	
	public Propietario seleccionarPorId(Integer id);


}
