package com.zarandas.proyecto.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Cliente;
import com.zarandas.proyecto.repositories.IClienteRepository;
import com.zarandas.proyecto.services.IClienteService;


@Service("clienteService")
public class ClienteService implements IClienteService{
	
	@Autowired
	@Qualifier("clienteRepository")
	private IClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscar(long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@Transactional
	@Modifying
	public void update(String nombre, String email, long idCliente) {
		clienteRepository.updateCliente(idCliente, nombre, email);
	}

}
