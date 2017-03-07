package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Historial;
import com.ipartek.formacion.repository.mapper.DadoMapper;
import com.ipartek.formacion.repository.mapper.HistorialMapper;

@Repository(value="dadoDAO")
public class DadoDAOImpl implements DadoDAO {

	
	@Autowired()
	private DataSource dataSource;	
	private JdbcTemplate jdbctemplate;

	@Autowired()
	@Override()
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);

	}
	
	@Override()
	public List<Historial> getHistorial() {
		ArrayList<Historial> historial= (ArrayList<Historial>) this.jdbctemplate.query(
				"SELECT u.id, u.nombre, t.fecha FROM tirada as t, usuario as u WHERE u.id=t.id_usuario ORDER BY t.fecha DESC;", 
				new HistorialMapper());
		return historial;
	}

	@Override()
	public List<Dado> getAllByUserId(int idUsuario) {
		ArrayList<Dado> dados= (ArrayList<Dado>) this.jdbctemplate.query(
				"SELECT `id`, `id_usuario`, `fecha` FROM `tirada` WHERE `id_usuario`= ? ORDER BY fecha DESC", 
				new Object[]{idUsuario},
				new DadoMapper());
		return dados;
	}
	
	@Override()
	public List<Dado> getLastByUserId(int idUsuario) {
			ArrayList<Dado> dados= (ArrayList<Dado>) this.jdbctemplate.query(
					"SELECT `id`, `id_usuario`, `fecha` FROM `tirada` WHERE `id_usuario`= ? ORDER BY fecha DESC LIMIT 1;", 
					new Object[]{idUsuario},
					new DadoMapper());
			return dados;
	}

	@Override()
	public boolean addTirada(int idUsuario) {
		boolean insertado= false;
		int lineasInsertadas= 0;
		lineasInsertadas= this.jdbctemplate.update(
				"INSERT INTO `tirada` (`id_usuario` ) values ( ? );", idUsuario);
		if (lineasInsertadas!=0) {
			insertado= true;
		}
		return insertado;
	}

	@Override()
	public int countAll() {
		int	contador=this.jdbctemplate.queryForInt(
				"SELECT COUNT(`id`) as 'total' FROM `tirada`");
		
	return contador;
	}

	@Override()
	public int countById(int idUsuario) {
		int	contador=this.jdbctemplate.queryForInt(
				"SELECT COUNT(`id_usuario`) as 'total' FROM `tirada` WHERE `id_usuario`= ?", idUsuario);
		
	return contador;
	}

	
		

	

}
