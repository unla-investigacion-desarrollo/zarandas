package com.zarandas.proyecto.services.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Presupuesto;
import com.zarandas.proyecto.repositories.IPresupuestoRepository;
import com.zarandas.proyecto.services.IPresupuestoService;

@Service("presupuestoService")
public class PresupuestoService implements IPresupuestoService{
	
	@Autowired
	@Qualifier("presupuestoRepository")
	private IPresupuestoRepository presupuestoRepository;

	@Override
	public List<Presupuesto> getAll() {
		return presupuestoRepository.findAll();
	}

	@Override
	public Presupuesto buscar(long id) {
		return presupuestoRepository.findById(id).orElse(null);
	}


	@Override
	public void save(Presupuesto presupuesto) {
		presupuestoRepository.save(presupuesto);
	}
	
	public Double calculateTotal(Presupuesto presupuesto) {
		Double resultado = 0d;
		Double iva = 0d;
		Double usdPieza = presupuesto.getValorProducto() / presupuesto.getValorUsd();
		resultado = usdPieza * presupuesto.getCantidad();
		iva = (resultado/100)*21;
		resultado = resultado + iva;
		return Math.ceil(resultado);
	}
	
	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Modifying
	public void update(long idPresupuesto, int cantidad, double valorProducto, double ancho, double largo,
			double valorUsd) {
		presupuestoRepository.updatePresupuesto(idPresupuesto, cantidad, valorProducto, ancho, largo, valorUsd);
	}
}
