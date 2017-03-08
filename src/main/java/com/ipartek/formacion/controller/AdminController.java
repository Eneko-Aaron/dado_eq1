package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.UsuarioService;
/**
 * Controlador para gestionar CRUD usuarios
 * @author Aaron
 *
 */
@Controller()
public class AdminController {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AdminController.class);
	@Autowired()
	private UsuarioService usuarioService;

	/**
	 * Mapping para listar todos los usuarios
	 * @param model usuario (nuevo usuario), usuarios(todos los usuarios)
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	/**
	 * Mapping para crear un nuevo usuario
	 * @param usuario Pojo usuario contra el que choca el formulario Crear
	 * @param model usuario(nuevo usuario), usuarios(todos los usuarios)
	 * @param bindingResult
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String crear(Usuario usuario, Model model, BindingResult bindingResult) {
		this.usuarioService.add(usuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	/**
	 * Mapping para modificar un usuario
	 * @param usuario Pojo usuario contra el que choca el formulario Modificacion
	 * @param model usuario(nuevo usuario), usuarios(todos los usuarios)
	 * @param bindingResult
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String modificar(Usuario usuario, Model model, BindingResult bindingResult) {
		this.usuarioService.update(usuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	/**
	 * Mapping para eliminar un usuario
	 * @param idUsuario id del usuario a eliminar
	 * @param model usuario(nuevo usuario), usuarios(todos los usuarios)
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin/eliminar/{idUsuario}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.delete(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	/**
	 * Mapping para dar de alta un usuario
	 * @param idUsuario id del usuario a dar de alta
	 * @param model usuario(nuevo usuario), usuarios(todos los usuarios)
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin/alta/{idUsuario}", method = RequestMethod.GET)
	public String darDeAlta(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.darDeAlta(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	/**
	 * Mapping para dar de baja un usuario
	 * @param idUsuario id del usuario a dar de baja
	 * @param model usuario(nuevo usuario), usuarios(todos los usuarios)
	 * @return admin/index
	 */
	@RequestMapping(value = "/admin/baja/{idUsuario}", method = RequestMethod.GET)
	public String darDeBaja(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.darDeBaja(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}
}
