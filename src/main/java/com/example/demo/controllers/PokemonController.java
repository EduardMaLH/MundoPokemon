package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/{tipo}")
    public ResponseEntity<List<Pokemon>> listarPorTipo(@PathVariable String tipo) {
        List<Pokemon> pokemones = pokemonRepository.findByTipoPokemon_Descripcion(tipo);
        return ResponseEntity.ok(pokemones);
        
        @PostMapping
        public ResponseEntity<Pokemon> registrarPokemon(@RequestBody Pokemon pokemon) {
            // Puedes realizar validaciones u otras operaciones antes de guardar el Pokémon
            Pokemon pokemonGuardado = pokemonRepository.save(pokemon);
            return ResponseEntity.ok(pokemonGuardado);
    }
}