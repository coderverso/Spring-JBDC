package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.models.dao.ClienteDaoImpl;
import com.springboot.models.entitys.Cliente;

@Controller
public class ControllerDaoCliente {

	@Autowired
	private  ClienteDaoImpl dao;
	
	@GetMapping("/")
	public String listado(Model modelo) {
		List<Cliente>lista=dao.listar();
		modelo.addAttribute("listaClientes", lista);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model modelo) {
		modelo.addAttribute("cliente", new Cliente());
		return "formNuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Cliente cliente) {
		dao.guardar(cliente);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable long id,Model modelo) {
		Cliente cliente =dao.buscarID(id);
		modelo.addAttribute("cliente", cliente);
		return "formEditar";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(@ModelAttribute Cliente cliente) {
		dao.actualizar(cliente);
		return "redirect:/";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable long id) {
		dao.borrar(id);
		return "redirect:/";
	}
	
	
	
	
	
}
