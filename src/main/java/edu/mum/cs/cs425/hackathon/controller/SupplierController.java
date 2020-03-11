package edu.mum.cs.cs425.hackathon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.hackathon.model.Supplier;
import edu.mum.cs.cs425.hackathon.repository.SupplierRepository;

@Controller
public class SupplierController {
	@Autowired
	private SupplierRepository supplierRepository;
	@GetMapping("/supplierlist")
	public ModelAndView getSupplierList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/supplier/supplierlist");
		modelAndView.addObject("suppliers", supplierRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/addsupplier")
	public ModelAndView addSupplier() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("supplier", new Supplier());
		modelAndView.setViewName("/supplier/addsupplier");
		return modelAndView;
	}
	
	@PostMapping("addsupplier")
	public String postSupplier(@Valid @ModelAttribute("supplier") Supplier supplier, BindingResult result) {
		if(result.hasErrors())
			return "/supplier/addsupplier";
		supplierRepository.save(supplier);
		return "redirect:/supplierlist";
	}
	
	@GetMapping("deletesupplier")
	public String deleteSupplier(@RequestParam("supplierid") long id) {
		supplierRepository.deleteById(id);
		return "redirect:/supplierlist";
	}
}
