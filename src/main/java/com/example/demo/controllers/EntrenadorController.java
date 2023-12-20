package com.example.demo.controllers;
import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Entrenador;
import com.example.demo.repositories.EntrenadorRepository;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findByEmail(email);

        if (entrenadorOptional.isPresent()) {
            Entrenador entrenador = entrenadorOptional.get();
            Map<String, String> response = new HashMap<>();
            response.put("uuid", entrenador.getUuid());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @GetMapping("/{uuid}/pokemons")
    public ResponseEntity<List<Pokemon>> listarPokemonesDeEntrenador(@PathVariable String uuid) {
        Optional<Entrenador> entrenadorOptional = entrenadorRepository.findByUuid(uuid);

        if (entrenadorOptional.isPresent()) {
            Entrenador entrenador = entrenadorOptional.get();
            List<Pokemon> pokemones = PokemonRepository.findByEntrenador(entrenador);
            return ResponseEntity.ok(pokemones);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
}
