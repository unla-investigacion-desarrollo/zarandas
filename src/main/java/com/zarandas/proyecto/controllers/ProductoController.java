package com.zarandas.proyecto.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("titulo", "Nuevo producto:");
		model.addAttribute("producto", producto);
		return "producto/crear";
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Producto producto, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo producto");
			System.out.println("Hubo error en el formulario!");
			return "producto/crear";
		}
		productoService.save(producto);
		System.out.println("Producto guardado con exito!");
		attribute.addFlashAttribute("success","Producto creado con exito");
		return "redirect:/producto/";
	}

}
