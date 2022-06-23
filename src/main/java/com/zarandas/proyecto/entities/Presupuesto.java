package com.zarandas.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "presupuesto")
public class Presupuesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPresupuesto;
	
	@Column(name = "cantidad")
	@NotNull(message="Campo requerido.")
	private int cantidad;
	
	@Column(name = "valorProducto")
	@NotNull(message="Campo requerido.")
	private Double valorProducto;
	
	@Column(name = "ancho")
	@NotNull(message="Campo requerido.")
	private Double ancho;
	
	@Column(name = "largo")
	@NotNull(message="Campo requerido.")
	private Double largo;
	
	@Column(name = "valorUsd")
	@NotNull(message="Campo requerido.")
	private Double valorUsd;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	@NotNull(message="Campo requerido.")
	private Producto producto;
	
	 public Presupuesto() {
	    	
	    }
	 
	public Presupuesto(
			@NotEmpty(message = "Campo requerido.") int cantidad,
			@NotEmpty(message = "Campo requerido.") Double valorProducto,
			@NotEmpty(message = "Campo requerido.") Double ancho, @NotEmpty(message = "Campo requerido.") Double largo,
			@NotEmpty(message = "Campo requerido.") Double valorUsd, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.valorProducto = valorProducto;
		this.ancho = ancho;
		this.largo = largo;
		this.valorUsd = valorUsd;
		this.producto = producto;
	}

	public long getIdPresupuesto() {
		return idPresupuesto;
	}

	protected void setIdPresupuesto(long idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(Double valorProducto) {
		this.valorProducto = valorProducto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getValorUsd() {
		return valorUsd;
	}

	public void setValorUsd(Double valorUsd) {
		this.valorUsd = valorUsd;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
