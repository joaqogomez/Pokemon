package fiuba.algo3.pokemon;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EntrenadorTest {

    private final Double DELTA = 1e-15;

    @Test
    public void test01SiElEntrenadorNoTienePokemonesElPromedioDeVidaDeLosPokemonesEs0() {

        Entrenador entrenador = new Entrenador("Ash");

        assertEquals(0, entrenador.promedioVidaPokemones(), DELTA);
    }

    @Test
    public void test02SiElEntrenadorTienePokemonesElPromedioDeVidaDeLosPokemonesEsElIndicado() {

        Entrenador entrenador = new Entrenador("Ash");
        entrenador.atrapar(new Pikachu());

        assertEquals(100, entrenador.promedioVidaPokemones(),DELTA);
    }

    @Test
    public void test03SiElEntrenadorTiene2PokemonesElPromedioDeVidaDeLosPokemonesEsElIndicado() {

        Entrenador entrenador = new Entrenador("Ash");
        entrenador.atrapar(new Pikachu());
        entrenador.atrapar(new Pikachu());

        assertEquals(100, entrenador.promedioVidaPokemones(), DELTA);
    }



    @Test
    public void test04CuandoBuscamosLaCantidadDePokemonesMuertosEsLaIndicada() {

        Entrenador entrenador1 = new Entrenador("Ash");
        Entrenador entrenador2 = new Entrenador("Juan");
        entrenador1.atrapar(new Pikachu());
        entrenador1.atrapar(new Pikachu());

        entrenador2.atrapar(new Pikachu());
        entrenador2.atrapar(new Pikachu());
        entrenador2.atrapar(new Pikachu());
        entrenador2.atrapar(new Pikachu());
        entrenador2.atrapar(new Pikachu());

        entrenador1.atacar(entrenador2);
        entrenador1.atacar(entrenador2);
        entrenador1.atacar(entrenador2);
        entrenador1.atacar(entrenador2);
        entrenador1.atacar(entrenador2);

        assertEquals(1, entrenador2.cantidadPokemonesMuertos());
    }
}