package aula_api.pokeapiaula.entities;

public record Pokemon(Integer id, String name, double height ) {
    @Override
    public String toString() {
        return """
               Pokemon encontrado!
               ID: %d
               Name: %s
               Height (cm): %d
               """.formatted(id, name, height);
    }
}


