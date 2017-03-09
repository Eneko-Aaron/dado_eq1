package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Historial;
/**
 * Servicio para gestionar DadoDAO
 * @author Equipo 1
 *
 */
public interface DadoService {
	
	/**
	 * Recoge todas las tiradas en orden descendiente de fecha
	 * @return List<Historial>
	 */
	List<Historial> getHistorial();
	
	/**
	 * Añade una tirada realizada por un usuario
	 * @param idUsuario id usuario
	 * @return true: si añade la linea. false si no pudo
	 */
	boolean addTirada( int idUsuario);

}
