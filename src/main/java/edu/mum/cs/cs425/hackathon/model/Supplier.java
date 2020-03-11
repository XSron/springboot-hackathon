package edu.mum.cs.cs425.hackathon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "suppliers")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;
	@NotBlank
	private String supplierNumber;
	@NotBlank
	private String name;
	@NotBlank
	private String contactPhoneNumber;
	@OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
	private List<Product> products;
	public Supplier() {}
	public Supplier(@NotBlank String supplierNumber, @NotBlank String name, @NotBlank String contactPhoneNumber) {
		super();
		this.supplierNumber = supplierNumber;
		this.name = name;
		this.contactPhoneNumber = contactPhoneNumber;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierNumber() {
		return supplierNumber;
	}
	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}
}
