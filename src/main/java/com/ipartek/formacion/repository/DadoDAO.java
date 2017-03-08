package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Historial;
/**
 * DAO para gestionar la tabla tiradas
 * @author Aaron
 *
 */
public interface DadoDAO {
	/**
	 * Conexion a BBDD
	 * @param dataSource pool de conexiones
	 */
	void setDataSource(DataSource dataSource);
	
	/**
	 * Recoge todas las tiradas en orden descendiente de fecha
	 * @return List<Historial>
	 */
	List<Historial> getHistorial();
	
	/**
	 * Recoge todas las tiradas de un usuario en orden descendente de fecha
	 * @param idUsuario id de usuario
	 * @return List<Dado>
	 */
	List<Dado> getAllByUserId(int idUsuario);
	
	/**
	 * Recoge la ultima tirada de un usuario
	 * @param idUsuario id de usuario
	 * @return List<Dado>
	 */
	List<Dado> getLastByUserId(int idUsuario);
	
	/**
	 * Añade una tirada realizada por un usuario
	 * @param idUsuario id usuario
	 * @return true: si todo funciona 
	 */
	boolean addTirada( int idUsuario);
	
	int countById(int idUsuario);
	
	int countAll();
	
	
	
	
}
