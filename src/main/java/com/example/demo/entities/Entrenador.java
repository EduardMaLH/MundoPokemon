package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	 @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
	    private List<Pokemon> pokemones;
}
