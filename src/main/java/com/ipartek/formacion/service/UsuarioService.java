package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAll();
	
	List<Usuario> getAllAlta();
	
	List<Usuario> getAllOrderByTiradas();
	
	Usuario getById( int idUsuario );
	
	boolean add( Usuario usuario );
	
	boolean update( Usuario usuario );
	
	boolean delete ( int idUsuario );
	
	boolean darDeAlta(int idUsuario);
	
	boolean darDeBaja(int idUsuario);
	
	int count();
	
	int countAlta();
	
	

}
