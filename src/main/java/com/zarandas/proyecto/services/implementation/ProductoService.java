package com.zarandas.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.repositories.IProductoRepository;
import com.zarandas.proyecto.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository permisoRepository;

	@Override
	public List<Producto> getAll() {
		return permisoRepository.findAll();
	}

	@Override
	public Producto buscar(long id) {
		return permisoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Producto producto) {
		permisoRepository.save(producto);
		
	}

}
