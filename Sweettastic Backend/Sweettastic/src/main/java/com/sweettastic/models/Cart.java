package com.sweettastic.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double grandTotal;

	@JsonIgnore
	@OneToMany
	//@ElementCollection
	private List<Product> listProduct=new ArrayList<>();
	private Integer productCount;
	private Double total;

}
