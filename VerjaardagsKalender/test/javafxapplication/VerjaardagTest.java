package javafxapplication;

import model.Verjaardag;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class VerjaardagTest {

    Verjaardag verjaardag = new Verjaardag("Kees", LocalDate.of(1950, 2, 21));

    @Test
    public void testToString() {
        System.out.println(verjaardag);
        assertEquals("21/02 Kees 70", verjaardag.toString());
    }

    @Test
    public void testGetVolgendeVerjaardag() {
        System.out.println(verjaardag.getVolgendeVerjaardag());
        assertEquals("2020-02-21", verjaardag.getVolgendeVerjaardag().toString());
    }
}
