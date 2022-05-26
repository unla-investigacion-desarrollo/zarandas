package com.zarandas.proyecto.services;

import java.util.List;

import com.zarandas.proyecto.entities.Producto;


public interface IProductoService {
	
	public List<Producto> getAll();

	public Producto buscar(long id);

	public void eliminar(long id);
	
	public void save(Producto producto);

}
