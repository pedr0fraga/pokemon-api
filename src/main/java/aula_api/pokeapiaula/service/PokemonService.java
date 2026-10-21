package aula_api.pokeapiaula.service;

import aula_api.pokeapiaula.entities.Pokemon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {
    private final RestClient client;

    private final List<String> list30Pokemon = new ArrayList<>();

    public PokemonService() {
        this.client = RestClient.builder().baseUrl("https://pokeapi.co/api/v2").build();
    }

    public String getPokemonByName (String pokemon_name){
        return  Objects.requireNonNull(client.get()
                        .uri("/pokemon/{pokemon_name}", pokemon_name)
                        .retrieve()
                        .body(Pokemon.class)).toString();
    }
    public List<String> get30Pokemons(){
        for(int i = 1; i <= 30; i++){
            list30Pokemon.add(Objects.requireNonNull(client.get()
                    .uri("/pokemon/{id}", i)
                    .retrieve()
                    .body(Pokemon.class)).toString());
        }
        return list30Pokemon;
    }
}
