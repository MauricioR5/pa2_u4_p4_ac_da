package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements PropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	 @Transactional(value = TxType.REQUIRED)

	public void insertar(Propietario propietario) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		this.entityManager.persist(propietario);

	}

	@Override
	 @Transactional(value = TxType.REQUIRED)

	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);

	}

	
	@Override
	 @Transactional(value = TxType.REQUIRED)

	public void eliminar(Integer id) {
		this.entityManager.remove(id);

	}

	@Override
	 @Transactional(value = TxType.NOT_SUPPORTED)

	public List<Propietario> buscarTodos() {
		TypedQuery<Propietario> query = this.entityManager.createQuery("SELECT p FROM Propietario p",
				Propietario.class);
		return query.getResultList();
	}

}
