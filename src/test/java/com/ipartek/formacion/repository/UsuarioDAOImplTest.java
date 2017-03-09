package com.ipartek.formacion.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.domain.Usuario;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UsuarioDAOImplTest {

	@Autowired()
	private UsuarioDAO usuarioDAO;

	static Usuario usuario1 = null;
	static Usuario usuario2 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		usuario1 = new Usuario();
		usuario1.setNombre("Eneko");
		usuario2 = new Usuario();
		usuario2.setNombre("Aaron");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		usuario1 = null;
		usuario2 = null;
	}

	@Before
	public void setUp() throws Exception {
		this.usuarioDAO.add(usuario1);
		this.usuarioDAO.add(usuario2);
	}

	@After
	public void tearDown() throws Exception {
		this.usuarioDAO.delete(usuario1.getId());
		this.usuarioDAO.delete(usuario2.getId());
	}

	@Test
	public void testGetAll() {
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.usuarioDAO.getAll();
		assertEquals(usuario1, usuarios.get(0));
		assertEquals(usuario2, usuarios.get(1));
	}

}
