package com.zarandas.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@Column(name = "nombre")
	@NotEmpty(message="El nombre no debe estar vacio")
	private String nombre;
	
	@Column(name = "email")
	@NotEmpty(message="El email no debe estar vacio")
	private String email;
	
	 public Cliente() {
	    	
	    }

	public Cliente(String nombre,String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
