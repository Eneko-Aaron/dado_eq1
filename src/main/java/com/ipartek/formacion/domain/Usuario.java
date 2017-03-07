package com.ipartek.formacion.domain;

import java.util.Date;
import java.util.List;

public class Usuario {
	private int idUsuario;
	private String nombre;
	
	private Date fechaAlta;
	private	Date fechaBaja;
	private Date fechaModificacion;
	
	private List<Dado> tiradas;
	private int numTiradas;
	
	//constructor
	public Usuario() {
		super();
		this.idUsuario= -1;
		this.nombre= "";
		
	}

	//getter & setter
	public int getId() {
		return this.idUsuario;
	}


	public void setId(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public List<Dado> getTiradas() {
		return this.tiradas;
	}

	public void setTiradas(List<Dado> tiradas) {
		this.tiradas = tiradas;
	}

	public int getNumTiradas() {
		return this.numTiradas;
	}

	public void setNumTiradas(int numTiradas) {
		this.numTiradas = numTiradas;
	}
	
	//toString
	@Override()
	public String toString() {
		return "Usuario [id=" + this.idUsuario + ", nombre=" + this.nombre + ", fecha_alta=" + this.fechaAlta + ", fecha_baja=" + this.fechaBaja
				+ ", fecha_modificacion=" + this.fechaModificacion + ", tiradas=" + this.tiradas + ", numTiradas=" + this.numTiradas
				+ "]";
	}

	
	
	

	
	
	
}
