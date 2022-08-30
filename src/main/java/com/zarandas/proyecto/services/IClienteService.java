package com.zarandas.proyecto.services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Cliente;

public interface IClienteService {
	
	public List<Cliente> getAll();

	public Cliente buscar(long id);

	public void eliminar(long id);
	
	public void save(Cliente cliente);
	
	@Transactional
	@Modifying
	void update(String nombre, String email, long idCliente);

}
