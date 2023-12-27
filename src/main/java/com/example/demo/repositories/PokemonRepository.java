package com.example.demo.repositories;
import com.example.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {
    List<Pokemon> findByTipoPokemon_Descripcion(String tipo);
    static List<Pokemon> findByEntrenador(Entrenador entrenador) {
		
		return null;
	}
    Optional<Pokemon> findByUuid(String uuid);
}
