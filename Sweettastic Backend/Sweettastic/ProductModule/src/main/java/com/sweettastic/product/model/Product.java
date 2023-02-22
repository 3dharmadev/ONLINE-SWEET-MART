package com.sweettastic.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1, initialValue = 1)
	private Integer productid;
	
	@NotNull
	@Size(min=3, max=40)
	private String name;
	
	@NotNull
	private String photopath;
	
	@NotNull
	private Double price;
	
	@NotNull
	private String description;
	
	@NotNull
	private Boolean available;
	
	@NotNull
	private Category category;
}
