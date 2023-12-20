package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Entrenador {
	
	@Id
	@Column
	private Integer id;
	
	@Column(nullable=false, length=50)
	private String nombre;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@Column(nullable=false, length=50)
	private String uuid;
}
