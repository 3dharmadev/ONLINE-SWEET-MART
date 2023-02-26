package com.sweettastic.models;
import java.util.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@NotNull
	@Size(min = 4,max=30,message = "min length should 4 and max will 30")
	private String username;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)//targetEntity=SweetItem.class
	@JoinColumn(referencedColumnName = "userId")
	private Set<SweetOrder> sweetOrders=new HashSet<>();// override equals and hashcode

	@JsonIgnore
	@OneToOne
	private Cart cart;


	@Override
	public String toString() {
		return "Customer{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				'}';
	}
}
