package com.zarandas.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Presupuesto;



@Repository("presupuestoRepository")
public interface IPresupuestoRepository extends JpaRepository<Presupuesto, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Presupuesto p SET p.cantidad=(:cantidad) , p.valorProducto=(:valorProducto), p.ancho=(:ancho), p.largo=(:largo), p.valorUsd=(:valorUsd) WHERE p.idPresupuesto = (:idPresupuesto)")
	public abstract void updatePresupuesto(@Param("idPresupuesto") long idPresupuesto, 
			@Param("cantidad") int cantidad,
			@Param("valorProducto") double valorProducto,
			@Param("ancho") double ancho,
			@Param("largo") double largo,
			@Param("valorUsd") double valorUsd);

}
