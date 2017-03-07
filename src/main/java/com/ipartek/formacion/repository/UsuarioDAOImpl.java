package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.repository.mapper.UsuarioConTiradasMapper;
import com.ipartek.formacion.repository.mapper.UsuarioMapper;

@Repository(value = "usuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {

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
	public List<Usuario> getAll() {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.jdbctemplate.query(
				"SELECT `id`,  `nombre`, `fecha_alta`, `fecha_baja`, `fecha_modificacion` FROM usuario ORDER BY `id` DESC;",
				new UsuarioMapper());
		return usuarios;
	}
	
	@Override
	public List<Usuario> getAllAlta() {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.jdbctemplate.query(
				"SELECT `id`,  `nombre`, `fecha_alta`, `fecha_baja`, `fecha_modificacion` FROM usuario WHERE `fecha_baja` IS NULL ORDER BY `id` DESC;",
				new UsuarioMapper());
		return usuarios;
	}

	@Override()
	public List<Usuario> getAllOrderByTiradas() {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.jdbctemplate.query(
				"SELECT u.id, u.nombre , count(u.id) as total FROM usuario as u, tirada as t WHERE u.id = t.id_usuario AND `fecha_baja` IS NULL GROUP BY u.id ORDER BY total DESC LIMIT 3;",
				new UsuarioConTiradasMapper());
		return usuarios;
	}

	@Override()
	public Usuario getById(int idUsuario) {
		Usuario usuario = this.jdbctemplate.queryForObject("SELECT `id`, `nombre`, `fecha_alta`, `fecha_baja`, `fecha_modificacion` FROM `usuario` WHERE `id`= ?",
				new Object[] { idUsuario }, new UsuarioMapper());
		return usuario;
	}

	@Override()
	public boolean add(final Usuario usuario) {
		boolean insertado = false;
		int lineasInsertadas = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		lineasInsertadas = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepared = connection.prepareStatement("INSERT INTO `usuario` (`nombre`) VALUES (?)",
						Statement.RETURN_GENERATED_KEYS);
				prepared.setString(1, usuario.getNombre());
				return prepared;
			}
		}, keyHolder);
		if (lineasInsertadas != 0) {
			insertado = true;
			usuario.setId(keyHolder.getKey().intValue());
		}

		return insertado;
	}

	@Override()
	public boolean update(Usuario usuario) {
		boolean modificado = false;
		int lineasModificadas = 0;
		lineasModificadas = this.jdbctemplate.update("UPDATE `usuario` SET `nombre`= ? WHERE `id`= ?", usuario.getNombre(), usuario.getId());
		if (lineasModificadas != 0) {
			modificado = true;
		}
		return modificado;
	}

	@Override()
	public boolean delete(int idUsuario) {
		boolean borrado = false;
		int lineasBorradas = 0;
		lineasBorradas = this.jdbctemplate.update("DELETE FROM `usuario` WHERE `id`= ? ;", idUsuario);
		if (lineasBorradas != 0) {
			borrado = true;
		}
		return borrado;
	}

	@Override()
	public int count() {
		int contador = this.jdbctemplate.queryForInt("SELECT COUNT(`id`) as 'total' FROM `usuario`");

		return contador;
	}

	@Override()
	public boolean darDeAlta(int idUsuario) {
		boolean modificado = false;
		int lineasModificadas = 0;
		lineasModificadas = this.jdbctemplate.update(
				"UPDATE `usuario` SET `fecha_alta`= CURRENT_TIMESTAMP, `fecha_baja`=NULL WHERE `id`= ? ;", idUsuario);
		if (lineasModificadas != 0) {
			modificado = true;
		}
		return modificado;
	}

	@Override()
	public boolean darDeBaja(int idUsuario) {
		boolean modificado = false;
		int lineasModificadas = 0;
		lineasModificadas = this.jdbctemplate
				.update("UPDATE `usuario` SET `fecha_baja`= CURRENT_TIMESTAMP WHERE `id`= ? ;", idUsuario);
		if (lineasModificadas != 0) {
			modificado = true;
		}
		return modificado;
	}

	@Override
	public int countAlta() {
		int contador = this.jdbctemplate.queryForInt("SELECT COUNT(`id`) as 'total' FROM `usuario` WHERE `fecha_baja` IS NULL");

		return contador;
	}

	

}
