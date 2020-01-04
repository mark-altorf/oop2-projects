package javafxapplication;

import model.Kalender;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class KalenderTest {

    @Test
    public void testSorteerEnGetVerjaardagen() {
        System.out.println("sorteerEnGetVerjaardagen");
        Kalender instance = new Kalender("");
        instance.voegToe("Kees", LocalDate.of(1950, 2, 21));
        instance.voegToe("Henk", LocalDate.of(1953, 9, 29));
        String expResult = "29/09 Henk 66";
        String result = instance.sorteerEnGetVerjaardagen().get(0).toString();
        assertEquals(expResult, result);
    }
}
