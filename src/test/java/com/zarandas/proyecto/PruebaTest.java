package com.zarandas.proyecto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;

import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.services.implementation.ProductoService;

@RunWith(Runner.class)
public class PruebaTest {
	
	ProductoService service;
	
	@Test
	public void test() {
		
		Producto producto = service.buscar(1L);
		
		assertEquals("hola", producto.getNombre());
		
	}

}
