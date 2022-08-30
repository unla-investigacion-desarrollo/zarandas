package com.zarandas.proyecto.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.zarandas.proyecto.entities.Cliente;
import com.zarandas.proyecto.services.IClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private long idUpdate=0;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/crear";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			System.out.println("Hubo error en el formulario!");
			return "cliente/crear";
		}
		cliente.setHabilitado(true);
		clienteService.save(cliente);
		return "redirect:/cliente/lista";
	}
	
	@PostMapping("/guardarUpdate")
	public String guardarUpdate(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo cliente");
			System.out.println("Hubo error en el formulario!");
			return "cliente/crear";
		}
		if(idUpdate!=0) {
			clienteService.update(cliente.getNombre(), cliente.getEmail(), idUpdate);
			idUpdate=0;
			return "redirect:/cliente/lista";
		}
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/lista")
	public String listarProductos(Model model) {
		List<Cliente> clientes = clienteService.getAll();
		clientes = clientes.stream().filter(cliente -> Boolean.TRUE.equals(cliente.isHabilitado())).collect(Collectors.toList());
		model.addAttribute("titulo", "Clientes");
		model.addAttribute("lista", clientes);
		return "cliente/lista";
	}
	
	@GetMapping("/edit/{idCliente}")
	public String edit(@PathVariable("idCliente") long idCliente,Model model) {
		Cliente cliente = clienteService.buscar(idCliente);
		idUpdate=idCliente;
		model.addAttribute("cliente", cliente);
		return "cliente/update";
	}
	
	@GetMapping("/delete/{idCliente}")
	public String delete (@PathVariable("idCliente") long idCliente,Model model,RedirectAttributes attribute) {
		Cliente cliente = clienteService.buscar(idCliente);
		cliente.setHabilitado(false);
		clienteService.save(cliente);
		return "redirect:/cliente/lista";
	}

}
