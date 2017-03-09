package com.ipartek.formacion.domain;

import java.util.Date;
/**
 * Pojo Dado
 * @author Equipo 1
 *
 */
public class Dado {
	private int idDado;
	private int numero;
	private Date fecha;
	
	/**
	 * Constructor Dado
	 */
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
	
	@Override()
	public String toString() {
		return "Dado [id=" + this.idDado + ", numero=" + this.numero + ", fecha=" + this.fecha + "]";
	}
	
	/**
	 * Set-ea la propiedad numero con un numero aleatorio
	 * @param numUsuarios  numero aleatorio maximo
	 */
	public void lanzar(int numUsuarios){
		this.numero= 1 +(int)(Math.random()*numUsuarios);
	}
	
	
}
