package com.zarandas.proyecto.services;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Presupuesto;

public interface IPresupuestoService {
	
	public List<Presupuesto> getAll();

	public Presupuesto buscar(long id);

	public void eliminar(long id);
	
	public void save(Presupuesto presupuesto);
	
	public Double calculateTotal(Presupuesto presupuesto);
	
	@Transactional
	@Modifying
	void update(long idPresupuesto, int cantidad, double valorProducto, double ancho, double largo, double valorUsd);

}
