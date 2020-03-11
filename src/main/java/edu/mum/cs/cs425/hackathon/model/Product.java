package edu.mum.cs.cs425.hackathon.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	@NotBlank
	private String productNumber;
	@NotBlank
	private String name;
	@NotNull
	private double unitPrice;
	@NotNull
	private int quantityInStock;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateSupplied;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "supplierid")
	private Supplier supplier;
	public Product() {}
	public Product(@NotBlank String productNumber, @NotBlank String name, @NotNull double unitPrice,
			@NotNull int quantityInStock, LocalDate dateSupplied, Supplier supplier) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantityInStock = quantityInStock;
		this.dateSupplied = dateSupplied;
		this.supplier = supplier;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public LocalDate getDateSupplied() {
		return dateSupplied;
	}
	public void setDateSupplied(LocalDate dateSupplied) {
		this.dateSupplied = dateSupplied;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
