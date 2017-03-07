package com.ipartek.formacion.domain;

import java.util.Date;

public class Dado {
	private int idDado;
	private int numero;
	private Date fecha;
	
	//constructor
	public Dado() {
		super();
		this.idDado= -1;
		
	}
	
	//Getter & Setter
	public int getId() {
		return this.idDado;
	}
	public void setId(int idDado) {
		this.idDado = idDado;
	}
	public int getNumero() {
		return this.numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	//toString
	@Override()
	public String toString() {
		return "Dado [id=" + this.idDado + ", numero=" + this.numero + ", fecha=" + this.fecha + "]";
	}
	
	public void lanzar(int numUsuarios){
		this.numero= 1 +(int)(Math.random()*numUsuarios);
	}
	
	
}
