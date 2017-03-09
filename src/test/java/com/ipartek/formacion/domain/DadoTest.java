package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DadoTest {

	static final int idDado = 1;
	static final int numero = 2;
	static final Date fecha = new Date();

	static final int max = 10;
	static final int min = 1;
	static final int maxUsuarios = 10;

	static Dado dado = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dado = new Dado();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dado = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {

		assertEquals(-1, dado.getId());
		assertEquals(0, dado.getNumero());
		assertEquals(null, dado.getFecha());

	}

	@Test
	public void testSetterGetter() {

		dado.setId(idDado);
		assertEquals(idDado, dado.getId());

		dado.setNumero(numero);
		assertEquals(numero, dado.getNumero());

		dado.setFecha(fecha);
		assertEquals(fecha, dado.getFecha());

	}

	@Test
	public void testLanzar() {
		dado.lanzar(maxUsuarios);
		assertTrue(max >= dado.getNumero());
		assertTrue(min <= dado.getNumero());
	}

}
