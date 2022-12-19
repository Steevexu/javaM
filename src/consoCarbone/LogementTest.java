package consoCarbone;
// JUnit Test du calcul de l'impact de Logement
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogementTest {

    @Test
    void calc_impact() {
        var test2 = new Logement(100,CE.G);
        assertEquals(10,test2.calc_impact());
    }
}