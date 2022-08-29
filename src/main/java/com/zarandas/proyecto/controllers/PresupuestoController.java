package com.zarandas.proyecto.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.zarandas.proyecto.entities.Presupuesto;
import com.zarandas.proyecto.entities.Producto;
import com.zarandas.proyecto.services.IPresupuestoService;
import com.zarandas.proyecto.services.IProductoService;

@Controller
@RequestMapping("/presupuesto")
public class PresupuestoController {
	
	private long idUpdate=0;
	
	@Autowired
	@Qualifier("presupuestoService")
	private IPresupuestoService presupuestoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@RequestMapping("/")
	public String crear(Model model) {
		Presupuesto presupuesto = new Presupuesto();
		List<Producto> listaProductos = productoService.getAll();
		model.addAttribute("presupuesto", presupuesto);
		model.addAttribute("productos", listaProductos);
		return "presupuesto/crear";
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Presupuesto presupuesto, BindingResult result, Model model, RedirectAttributes attribute) {
		if(presupuesto.getCantidad()==0) {
			FieldError error = new FieldError("presupuesto", "cantidad", "La cantidad no puede ser 0");
			result.addError(error);
		}
		if(result.hasErrors()) {
			List<Producto> listaProductos = productoService.getAll();
			model.addAttribute("productos", listaProductos);
			System.out.println("Hubo error en el formulario!");
			return "presupuesto/crear";
		}
		presupuestoService.save(presupuesto);
		System.out.println("Presupuesto creado con exito!");
		System.out.println(presupuestoService.calculateTotal(presupuesto));
		attribute.addFlashAttribute("success","Presupuesto creado con exito");
		return "redirect:/presupuesto/";
	}
	
	@GetMapping("/lista")
	public String listarRodados(Model model) {
		List<Presupuesto> presupuestos = presupuestoService.getAll();
		model.addAttribute("titulo", "Productos");
		model.addAttribute("lista", presupuestos);
		return "presupuesto/lista";
	}
	
	@GetMapping("/edit/{idPresupuesto}")
	public String edit(@PathVariable("idProducto") long idPresupuesto,Model model) {
		Presupuesto presupuesto = presupuestoService.buscar(idPresupuesto);
		idUpdate=idPresupuesto;
		model.addAttribute("presupuesto", presupuesto);
		return "presupuesto/update";
	}
	
	@GetMapping("/delete/{idPresupuesto}")
	public String delete (@PathVariable("idPresupuesto") long idPresupuesto,Model model,RedirectAttributes attribute) {
		presupuestoService.eliminar(idPresupuesto);
		return "redirect:/presupuesto/lista";
	}

}
