package com.nimap.crudOperations.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(name = "Product_Name", nullable = true, unique = false)
	    private String name;

	    @Column(name = "Product_Price", nullable = true, unique = false)
	    private float price;

	    @Column(name = "quantity", nullable = true, unique = false)
	    private int quantity;

	    @Column(name = "status", nullable = true, unique = false)
	    private String status;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "category_id", nullable = false)
	    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
	    private Category category;



	    public Product() {
	    }




	    public Product(int id, String name, float price, int quantity, String status, Category category) {
	        this.id = id;
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	        this.status = status;
	        this.category = category;
	    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + "]";
	}
}
