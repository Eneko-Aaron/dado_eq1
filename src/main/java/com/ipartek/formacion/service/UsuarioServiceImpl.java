package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.DadoDAO;
import com.ipartek.formacion.repository.UsuarioDAO;

@Service(value="usuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired() 
	private UsuarioDAO usuarioDAO;
	@Autowired() 
	private DadoDAO dadoDAO;

	@Override()
	public List<Usuario> getAll() {		
		return this.usuarioDAO.getAll();
	}
	
	@Override
	public List<Usuario> getAllAlta() {
		return this.usuarioDAO.getAllAlta();
	}

	@Override()
	public List<Usuario> getAllOrderByTiradas() {
		ArrayList<Usuario> usuarios= (ArrayList<Usuario>) this.usuarioDAO.getAllOrderByTiradas();
		for (Usuario u : usuarios) {
			u.setTiradas(this.dadoDAO.getAllByUserId(u.getId()));
			u.setNumTiradas(this.dadoDAO.countById(u.getId()));
		}
		return usuarios;
	}

	@Override()
	public Usuario getById(int idUsuario) {	
		return this.usuarioDAO.getById(idUsuario);
	}

	@Override()
	public boolean add(Usuario usuario) {
		return this.usuarioDAO.add(usuario);
	}

	@Override()
	public boolean update(Usuario usuario) {
		return this.usuarioDAO.update(usuario);
	}

	@Override()
	public boolean delete(int idUsuario) {
		return this.usuarioDAO.delete(idUsuario);
	}

	@Override()
	public boolean darDeAlta(int idUsuario) {
		return this.usuarioDAO.darDeAlta(idUsuario);
	}

	@Override()
	public boolean darDeBaja(int idUsuario) {
		return this.usuarioDAO.darDeBaja(idUsuario);
	}

	@Override()
	public int count() {
		return this.usuarioDAO.count();
	}

	@Override
	public int countAlta() {
		return this.usuarioDAO.countAlta();
	}

	

}
