package javafxapplication;

import data.Bestand;
import model.Verjaardag;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BestandTest {
    
    @Test
    public void testSchrijfWegEnLeesTerug() throws Exception {
        System.out.println("schrijfWeg en leesTerug");
        List<Verjaardag> verjaardagen = new ArrayList<>(0);
        verjaardagen.add(new Verjaardag("Henk", LocalDate.of(1953, 9, 29)));
        Bestand instance = new Bestand("kalender.dat");
        instance.schrijfWeg(verjaardagen);
        List<Verjaardag> result = instance.leesTerug();
        assertEquals(1, result.size());
        assertEquals("29/09 Henk 66", result.get(0).toString());
    }
}
