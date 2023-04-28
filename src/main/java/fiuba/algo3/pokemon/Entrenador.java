package fiuba.algo3.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entrenador {

    private final String nombre;
    private List<Pikachu> pokemones = new ArrayList();

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public int promedioVidaPokemonesV1() {
        if (pokemones.size() == 0) {
            return 0;
        }

        int vidaTotal = 0;
        for (int i = 0; i < pokemones.size(); i++) {
            vidaTotal += pokemones.get(i).getPuntos();
        }

        return vidaTotal / pokemones.size();
    }

    public int promedioVidaPokemonesV2() {
        if (pokemones.size() == 0) {
            return 0;
        }

        int vidaTotal = 0;
        for (Pokemon pokemon : pokemones) {
            vidaTotal += pokemon.getPuntos();
        }

        return vidaTotal / pokemones.size();
    }

    public int promedioVidaPokemonesV3() {
        if (pokemones.size() == 0) {
            return 0;
        }

        int vidaTotal = pokemones.stream()
                .map(pokemon -> pokemon.getPuntos())
                .reduce((x, y) -> x + y)
                .orElse(0);

        return vidaTotal / pokemones.size();
    }

    public int promedioVidaPokemonesV4() {
        if (pokemones.size() == 0) {
            return 0;
        }

        int vidaTotal = pokemones.stream()
                .mapToInt(pokemon -> pokemon.getPuntos())
                .sum();

        return vidaTotal / pokemones.size();
    }



    public double promedioVidaPokemonesV5() {
        return pokemones.stream()
                .mapToInt(pokemon -> pokemon.getPuntos())
                .average()
                .orElse(0);
    }

    public double promedioVidaPokemones() {
        return pokemones.stream()
                .mapToInt(Pokemon::getPuntos)
                .average()
                .orElse(0);
    }

    public void atrapar(Pikachu pokemon) {
        pokemones.add(pokemon);
    }

    public void atacar(Entrenador entrenador) {
        this.pokemones.get(0).impacTrueno(entrenador.obtenerPrimerPokemon());
    }

    private Pokemon obtenerPrimerPokemon() {
        return this.pokemones.get(0);
    }

    public int cantidadPokemonesMuertos() {
        return this.pokemones.stream()
                .filter(pokemon -> pokemon.getPuntos() == 0)
                .collect(Collectors.toList())
                .size();
    }
}