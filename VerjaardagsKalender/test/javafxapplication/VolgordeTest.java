package javafxapplication;

import model.Verjaardag;
import org.junit.Test;
import util.Volgorde;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class VolgordeTest {
    
    @Test
    public void testCompare() {
        System.out.println("compare");
        Verjaardag o1 = new Verjaardag("Kees", LocalDate.of(1950, 2, 21));
        Verjaardag o2 = new Verjaardag("Henk", LocalDate.of(1953, 9, 29));
        Volgorde instance = new Volgorde();
        int expResult = 1;
        int result = instance.compare(o1, o2);
        assertEquals(expResult, result);
    }
}
