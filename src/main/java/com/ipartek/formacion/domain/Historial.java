package com.ipartek.formacion.domain;

import java.util.Date;

/**
 * 
 * @author Equipo 1
 *
 */
public class Historial {
	private Usuario usuario;
	private Date fecha;

	public Usuario getU() {
		return this.usuario;
	}
	public void setU(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override()
	public String toString() {
		return "Historial [u=" + this.usuario.getNombre() + ", fecha=" + this.fecha + "]";
	}
	

}
