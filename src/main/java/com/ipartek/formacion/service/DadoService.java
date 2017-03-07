package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Historial;

public interface DadoService {
	List<Historial> getHistorial();
	
	List<Dado> getAllByUserId(int idUsuario);
	
	boolean addTirada( int idUsuario);

}
