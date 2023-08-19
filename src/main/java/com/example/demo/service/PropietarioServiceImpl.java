package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.PropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void agregar(Propietario propietario) {
		this.propietarioRepository.insertar(propietario);

	}

	@Override
	@Transactional(value = TxType.REQUIRED)

	public void actualizar(Propietario propietario) {
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)

	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public List<Propietario> buscarTodos() {
		return this.propietarioRepository.buscarTodos();
	}

	@Override
	public Propietario buscarPorId(Integer id) {
		return this.propietarioRepository.seleccionarPorId(id);
	}
}
