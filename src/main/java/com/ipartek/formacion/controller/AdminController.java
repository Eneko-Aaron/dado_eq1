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

@Controller()
public class AdminController {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AdminController.class);
	@Autowired()
	private UsuarioService usuarioService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String Crear(Usuario usuario, Model model, BindingResult bindingResult) {
		this.usuarioService.add(usuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String Modificar(Usuario usuario, Model model, BindingResult bindingResult) {
		this.usuarioService.update(usuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/eliminar/{idUsuario}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.delete(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/alta/{idUsuario}", method = RequestMethod.GET)
	public String darDeAlta(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.darDeAlta(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/baja/{idUsuario}", method = RequestMethod.GET)
	public String darDeBaja(@PathVariable() int idUsuario, Model model) {
		this.usuarioService.darDeBaja(idUsuario);
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", this.usuarioService.getAll());
		return "admin/index";
	}
}
