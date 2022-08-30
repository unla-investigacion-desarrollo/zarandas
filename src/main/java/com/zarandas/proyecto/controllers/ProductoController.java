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
import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {

	private long idUpdate=0;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@RequestMapping("")
	public String crear(Model model) {
		Producto producto = new Producto();
		model.addAttribute("titulo", "Nuevo producto:");
		model.addAttribute("producto", producto);
		return "producto/crear";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo producto");
			System.out.println("Hubo error en el formulario!");
			return "producto/crear";
		}
		producto.setHabilitado(true);
		productoService.save(producto);
		System.out.println("Producto guardado con exito!");
		return "redirect:/producto/lista";
	}
	
	@PostMapping("/guardarUpdate")
	public String guardarUpdate(@Valid @ModelAttribute Producto producto, BindingResult result, Model model, RedirectAttributes attribute) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo producto");
			System.out.println("Hubo error en el formulario!");
			return "producto/crear";
		}
		if(idUpdate!=0) {
			productoService.update(producto.getNombre(), idUpdate);
			System.out.println("Producto editado con exito!");
			idUpdate=0;
			return "redirect:/producto/lista";
		}
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/lista")
	public String listarProductos(Model model) {
		List<Producto> productos = productoService.getAll();
		productos = productos.stream().filter(producto -> Boolean.TRUE.equals(producto.isHabilitado())).collect(Collectors.toList());
		model.addAttribute("titulo", "Productos");
		model.addAttribute("lista", productos);
		return "producto/lista";
	}
	
	@GetMapping("/edit/{idProducto}")
	public String edit(@PathVariable("idProducto") long idProducto,Model model) {
		Producto producto = productoService.buscar(idProducto);
		idUpdate=idProducto;
		model.addAttribute("producto", producto);
		return "producto/update";
	}
	
	@GetMapping("/delete/{idProducto}")
	public String delete (@PathVariable("idProducto") long idProducto,Model model,RedirectAttributes attribute) {
		Producto producto = productoService.buscar(idProducto);
		producto.setHabilitado(false);
		productoService.save(producto);
		return "redirect:/producto/lista";
	}
	
}
