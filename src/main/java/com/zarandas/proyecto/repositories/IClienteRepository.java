package com.zarandas.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Cliente;

@Repository("clienteRepository")
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Cliente c SET c.nombre=(:nombre), c.email=(:email) WHERE c.idCliente = (:idCliente)")
	public abstract void updateCliente(@Param("idCliente") long idCliente, @Param("nombre") String nombre, @Param("email") String email);

}
