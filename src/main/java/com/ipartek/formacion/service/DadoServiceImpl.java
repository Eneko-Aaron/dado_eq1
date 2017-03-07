package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Historial;
import com.ipartek.formacion.repository.DadoDAO;

@Service(value="dadoService")
public class DadoServiceImpl implements DadoService {

	@Autowired()
	private DadoDAO dadoDAO;
	
	@Override()
	public List<Historial> getHistorial() {
		return this.dadoDAO.getHistorial();
	}

	@Override()
	public List<Dado> getAllByUserId(int idUsuario) {
		return this.dadoDAO.getAllByUserId(idUsuario);
	}

	@Override()
	public boolean addTirada(int idUsuario) {
		return this.dadoDAO.addTirada(idUsuario);
	}

}
