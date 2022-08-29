package com.zarandas.proyecto.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zarandas.proyecto.entities.Producto;



@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Long> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET p.nombre=(:nombre) WHERE p.idProducto = (:idProducto)")
	public abstract void updateProducto(@Param("idProducto") long idProducto, @Param("nombre") String nombre);

}

