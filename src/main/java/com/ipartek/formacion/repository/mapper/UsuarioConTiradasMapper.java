package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Usuario;

public class UsuarioConTiradasMapper implements RowMapper<Usuario> {

	@Override()
	public Usuario mapRow(ResultSet resulSet, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setNumTiradas(resulSet.getInt("total"));
		usuario.setId(resulSet.getInt("id"));
		usuario.setNombre(resulSet.getString("nombre"));
		return usuario;
	}

}
