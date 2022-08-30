package com.zarandas.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProducto;
	
	@Column(name = "nombre")
	@NotEmpty(message="El nombre no debe estar vacio")
	private String nombre;
	
	@Column(name = "isHabilitado")
	private boolean isHabilitado;
	
    public Producto() {
    	
    }
    
	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public long getIdProducto() {
		return idProducto;
	}

	protected void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return isHabilitado;
	}

	public void setHabilitado(boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}
	
	
}
