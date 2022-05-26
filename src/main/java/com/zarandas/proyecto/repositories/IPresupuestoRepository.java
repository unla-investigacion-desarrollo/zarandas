package com.zarandas.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zarandas.proyecto.entities.Presupuesto;



@Repository("presupuestoRepository")
public interface IPresupuestoRepository extends JpaRepository<Presupuesto, Long>{

}
