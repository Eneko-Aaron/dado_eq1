package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Usuario;

public interface UsuarioService {
	
	/**
	 * Recoge todos los usuarios
	 * @return List<Usuario>
	 */
	List<Usuario> getAll();
	
	/**
	 * Recoge todos los usuarios de alta
	 * @return List<Usuarios>
	 */
	List<Usuario> getAllAlta();
	
	/**
	 *Recoge todos los usuarios con sus tiradas, ordenado por tiradas.
	 * @return List<Usuario>
	 */
	List<Usuario> getAllOrderByTiradas();
	
	/**
	 * Recoge un usuario
	 * @param idUsuario id de usuario
	 * @return Usuario
	 */
	Usuario getById( int idUsuario );
	
	/**
	 * Añade un usuario
	 * @param usuario usuario a crear
	 * @return true: si se ha añadido, false en caso contrario
	 */
	boolean add( Usuario usuario );
	
	/**
	 * Modifica un usuario
	 * @param usuario usuario a modificar
	 * @return true: si se ha modificado, false en caso contrario
	 */
	boolean update( Usuario usuario );
	
	/**
	 * Elimina un usuario
	 * @param idUsuario id de usuario
	 * @return true si se ha eliminado, false en caso contrario
	 */
	boolean delete ( int idUsuario );
	
	/**
	 * Da de alta un usuario
	 * @param idUsuario id usuario
	 * @return true si se da de alta, false en caso contrario
	 */
	boolean darDeAlta(int idUsuario);
	
	/**
	 * Da de baja un usuario
	 * @param idUsuario id de usuario
	 * @return true si se da de baja, false en caso contrario
	 */
	boolean darDeBaja(int idUsuario);
	
	/**
	 * Cuenta todos los usuarios
	 * @return int numero de usuarios
	 */
	int count();
	
	/**
	 * Da de alta un usuario
	 * @param idUsuario id usuario
	 * @return true si se da de alta, false en caso contrario
	 */
	int countAlta();
	
	

}
