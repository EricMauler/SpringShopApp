package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String brand;
	private double price;
	
	@ManyToOne
	private Category category;
	

	
	public Article (long id, String description, String brand, double price, Category category) {
		this.id = id;
		this.description = description;
		this.setBrand(brand);
	    this.setPrice(price); 
	    this.category = category;
	}
	
	public Article (String description, String brand, double price, Category category) {
		this.description = description;
		this.setBrand(brand);
	 this.setPrice(price); 
	 this.category = category;
	}
	
	public Article(String description, String brand, double price) {
		this.description = description;
		this.setBrand(brand);
	 this.setPrice(price); 
	}
	
	public Article(String description) {
		this.description = description;
	}
	
	public Article() {
		
	}

	public Article(String description, String brand, double price, long idCat) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = new Category (idCat);
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", brand=" + brand + ", price=" + price + "]";
	}

	public Article(Long id, String description, String brand, double price, long idCat) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = new Category (idCat);
	}

	public Long getId() {
		return id;
	}
	public long setId(Long id) {
		return this.id = id;
	}
	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}