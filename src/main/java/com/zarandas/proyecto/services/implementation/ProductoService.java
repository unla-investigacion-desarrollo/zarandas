package com.zarandas.proyecto.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.repositories.IProductoRepository;
import com.zarandas.proyecto.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto buscar(long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
	}
	
	@Transactional
	@Modifying
	public void update(String nombre, long idProducto) {
		productoRepository.updateProducto(idProducto, nombre);
	}

}
