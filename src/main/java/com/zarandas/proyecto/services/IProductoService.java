package com.zarandas.proyecto.services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Producto;


public interface IProductoService {
	
	public List<Producto> getAll();

	public Producto buscar(long id);

	public void eliminar(long id);
	
	public void save(Producto producto);

	@Transactional
	@Modifying
	void update(String nombre, long idProducto);

}
