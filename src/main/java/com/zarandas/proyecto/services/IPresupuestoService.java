package com.zarandas.proyecto.services;

import java.util.List;
import com.zarandas.proyecto.entities.Presupuesto;

public interface IPresupuestoService {
	
	public List<Presupuesto> getAll();

	public Presupuesto buscar(long id);

	public void eliminar(long id);
	
	public void save(Presupuesto presupuesto);
	
	public Double calculateTotal(Presupuesto presupuesto);

}
