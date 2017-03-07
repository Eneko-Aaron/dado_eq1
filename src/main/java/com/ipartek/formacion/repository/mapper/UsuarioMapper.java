package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Usuario;

public class UsuarioMapper implements RowMapper<Usuario> {

	@Override()
	public Usuario mapRow(ResultSet resulSet, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(resulSet.getInt("id"));
		usuario.setNombre(resulSet.getString("nombre"));
		usuario.setFechaAlta(resulSet.getTimestamp("fecha_alta"));
		usuario.setFechaBaja(resulSet.getTimestamp("fecha_baja"));
		usuario.setFechaModificacion(resulSet.getTimestamp("fecha_modificacion"));
		return usuario;
	}

}
