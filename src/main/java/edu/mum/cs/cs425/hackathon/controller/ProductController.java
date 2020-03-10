package edu.mum.cs.cs425.hackathon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.hackathon.model.Product;
import edu.mum.cs.cs425.hackathon.model.Supplier;
import edu.mum.cs.cs425.hackathon.repository.ProductRepository;
import edu.mum.cs.cs425.hackathon.repository.SupplierRepository;

@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SupplierRepository supplierRepository;
	@GetMapping("/productlist")
	public ModelAndView getProductList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/product/productlist");
		modelAndView.addObject("products", productRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/addproduct")
	public ModelAndView addSupplier() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("supplier", new Supplier());
		modelAndView.addObject("product", new Product());
		modelAndView.addObject("suppliers", supplierRepository.findAll());
		modelAndView.setViewName("/product/addproduct");
		return modelAndView;
	}
	
	@PostMapping("/addproduct")
	public String postSupplier(@Valid @ModelAttribute("product") Product product,@ModelAttribute("supplier") Supplier supplier, BindingResult result) {
		if(result.hasErrors())
			return "/product/addproduct";
		product.setSupplier(supplierRepository.findById(supplier.getSupplierId()).get());
		productRepository.save(product);
		return "redirect:/productlist";
	}
}
