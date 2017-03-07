package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Historial;

public interface DadoDAO {
	
	void setDataSource(DataSource dataSource);
	
	List<Historial> getHistorial();
	
	List<Dado> getAllByUserId(int idUsuario);
	
	List<Dado> getLastByUserId(int idUsuario);
	
	boolean addTirada( int idUsuario);
	
	int countById(int idUsuario);
	
	int countAll();
	
	
	
	
}
