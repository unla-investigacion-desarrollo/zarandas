package com.zarandas.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zarandas.proyecto.entities.Producto;



@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Long> {

}

