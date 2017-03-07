package com.ipartek.formacion.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Dado;
import com.ipartek.formacion.domain.Usuario;
import com.ipartek.formacion.service.DadoService;
import com.ipartek.formacion.service.UsuarioService;

@Controller()
public class DadoController {

	@Autowired()
	private UsuarioService usuarioService;
	@Autowired()
	private DadoService dadoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		model.addAttribute("ranking", this.usuarioService.getAllOrderByTiradas());
		return "home";
	}

	@RequestMapping(value = "/lanzar", method = RequestMethod.GET)
	public String dado(Model model) {
		Dado dado = new Dado();
		Usuario usuario = new Usuario();
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		dado.lanzar(this.usuarioService.countAlta());
		usuarios = (ArrayList<Usuario>) this.usuarioService.getAllAlta();
		usuario = usuarios.get(dado.getNumero() -1);
		
		this.dadoService.addTirada(usuario.getId());
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("ranking", this.usuarioService.getAllOrderByTiradas());
		model.addAttribute("historial", this.dadoService.getHistorial());
		return "home";
	}

	@RequestMapping(value = "/estadisticas", method = RequestMethod.GET)
	public String estadistica(Model model) {

		model.addAttribute("historial", this.dadoService.getHistorial());
		return "estadisticas/index";
	}
}
