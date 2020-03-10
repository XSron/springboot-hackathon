package edu.mum.cs.cs425.hackathon.repository;

import org.springframework.data.repository.CrudRepository;

import edu.mum.cs.cs425.hackathon.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
}
