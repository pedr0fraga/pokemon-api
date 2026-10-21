package aula_api.pokeapiaula.controller;

import aula_api.pokeapiaula.service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokeApi")

public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{pokemon_name}")
    public String pokemonNome(@PathVariable String pokemon_nome) {
        return pokemonService.getPokemonByName(pokemon_nome);
    }

    @GetMapping("/pokemon_30")
    public List<String> Pokemon30Limit(){
        return pokemonService.get30Pokemons();
    }
}
