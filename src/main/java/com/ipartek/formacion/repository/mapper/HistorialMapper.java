package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Historial;
import com.ipartek.formacion.domain.Usuario;

public class HistorialMapper implements RowMapper<Historial> {

	@Override()
	public Historial mapRow(ResultSet resulSet, int rowNum) throws SQLException {
		Historial historial = new Historial();
		Usuario usuario = new  Usuario();
		
		usuario.setNombre(resulSet.getString("nombre"));
		usuario.setId(resulSet.getInt("id"));
		
		historial.setU(usuario);
		historial.setFecha(resulSet.getTimestamp("fecha"));
		return historial;
	}

}
