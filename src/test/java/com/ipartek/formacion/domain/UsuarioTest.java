package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	static final int idUsuario = 1;
	static final String nombre = "Aaron";
	static final Date fechaAlta = new Date();
	static final Date fechaBaja = new Date();
	static final Date fechaModificacion = new Date();
	static final int numTiradas = 10;

	static List<Dado> dados = null;
	static Dado dado1 = null;
	static Dado dado2 = null;

	static Usuario usuario = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario();
		dados = new ArrayList<Dado>();
		dado1 = new Dado();
		dado1.setId(1);
		dado1.setNumero(1);
		dados.add(dado1);
		dado2 = new Dado();
		dado2.setId(2);
		dado2.setNumero(2);
		dados.add(dado2);

	}

	@AfterClass()
	public static void tearDownAfterClass() throws Exception {
		dado1 = null;
		dado2 = null;
		dados = null;
		usuario = null;
	}

	@Before()
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {

		assertEquals(-1, usuario.getId());
		assertEquals("", usuario.getNombre());
		assertEquals(null, usuario.getFechaAlta());
		assertEquals(null, usuario.getFechaBaja());
		assertEquals(null, usuario.getFechaModificacion());
		assertEquals(null, usuario.getTiradas());
		assertEquals(0, usuario.getNumTiradas());

	}

	@Test
	public void testSetterGetter() {

		usuario.setId(idUsuario);
		assertEquals(idUsuario, usuario.getId());
		usuario.setNombre(nombre);
		assertEquals(nombre, usuario.getNombre());
		usuario.setFechaAlta(fechaAlta);
		assertEquals(fechaAlta, usuario.getFechaAlta());
		usuario.setFechaBaja(fechaBaja);
		assertEquals(fechaBaja, usuario.getFechaBaja());
		usuario.setFechaModificacion(fechaModificacion);
		assertEquals(fechaModificacion, usuario.getFechaModificacion());
		usuario.setNumTiradas(numTiradas);
		assertEquals(numTiradas, usuario.getNumTiradas());
		usuario.setTiradas(dados);
		assertEquals(dados, usuario.getTiradas());
	}

}
