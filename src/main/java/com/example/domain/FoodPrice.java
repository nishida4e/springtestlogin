package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "foodprice")
public class FoodPrice {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "username")
	private User user;

}
