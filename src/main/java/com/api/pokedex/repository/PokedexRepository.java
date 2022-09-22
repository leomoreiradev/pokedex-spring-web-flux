package com.api.pokedex.repository;

import com.api.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokedexRepository extends ReactiveMongoRepository <Pokemon, String>{
}
