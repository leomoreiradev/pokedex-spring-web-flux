package com.api.pokedex.controller;


import com.api.pokedex.model.Pokemon;
import com.api.pokedex.repository.PokedexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/pokemons")
public class PokemonController {

     private final PokedexRepository pokedexRepository;

     @GetMapping
     public Flux<Pokemon> getAllPokemons(){
          return pokedexRepository.findAll();
     }

     @GetMapping(value ="/{id}")
     public Mono<ResponseEntity<Pokemon>> getPokemon(@PathVariable String id) {
          return pokedexRepository.findById(id)
                  .map(ResponseEntity::ok)
                  .defaultIfEmpty(ResponseEntity.notFound().build());
     }

     @PostMapping
     @ResponseStatus(HttpStatus.CREATED)
     public Mono<Pokemon> savePokemon(@RequestBody Pokemon pokemon) {
          return pokedexRepository.save(pokemon);
     }


}
