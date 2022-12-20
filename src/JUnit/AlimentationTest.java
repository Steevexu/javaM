package JUnit;

// JUnit Test du calcul de l'impact de Alimentation

import consoCarbone.Alimentation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlimentationTest {


    @Test
    void calc_impact() {
    var test1 = new Alimentation(0.8,0.9);
    assertEquals(6.09,test1.calc_impact());
    }

}