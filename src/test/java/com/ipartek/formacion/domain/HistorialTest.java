package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HistorialTest {
	static final Date fecha = new Date();
	static Usuario usuario = null;

	static Historial historial = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("Aaron");
		historial = new Historial();
	}

	@AfterClass()
	public static void tearDownAfterClass() throws Exception {
		historial = null;
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

		assertEquals(null, historial.getFecha());
		assertEquals(null, historial.getU());

	}

	@Test
	public void testSetterGetter() {
		historial.setFecha(fecha);
		assertEquals(fecha, historial.getFecha());
		historial.setU(usuario);
		assertEquals(usuario, historial.getU());
	}

}
