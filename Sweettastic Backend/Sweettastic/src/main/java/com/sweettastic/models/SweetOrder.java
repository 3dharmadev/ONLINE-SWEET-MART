package com.sweettastic.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SweetOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sweetOrderId;
	
	
	
	@ManyToOne
	@NotNull
	private Customer customer;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "sweetOrderId")
	private List<Product>  products=new ArrayList<>();
	
	@NotNull
	private LocalDate date;


	@Override
	public String toString() {
		return "SweetOrder{" +
				"sweetOrderId=" + sweetOrderId +
				", customer=" + customer +
				", date=" + date +
				'}';
	}
}
