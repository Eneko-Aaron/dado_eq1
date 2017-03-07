package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Dado;

public class DadoMapper implements RowMapper<Dado> {

	@Override()
	public Dado mapRow(ResultSet resulSet, int rowNum) throws SQLException {
		Dado dado = new Dado();
		dado.setId(resulSet.getInt("id"));
		dado.setNumero(resulSet.getInt("id_usuario"));
		dado.setFecha(resulSet.getTimestamp("fecha"));
		return dado;
	}

}
