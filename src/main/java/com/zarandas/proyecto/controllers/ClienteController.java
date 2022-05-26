package com.zarandas.proyecto.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zarandas.proyecto.entities.Cliente;

import com.zarandas.proyecto.services.IClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/crear";
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			System.out.println("Hubo error en el formulario!");
			return "cliente/crear";
		}
		clienteService.save(cliente);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success","Cliente creado con exito");
		return "redirect:/cliente/";
	}

}
