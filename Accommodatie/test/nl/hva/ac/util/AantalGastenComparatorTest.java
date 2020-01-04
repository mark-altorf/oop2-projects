package nl.hva.ac.util;

import nl.hva.ac.model.Accommodatie;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class AantalGastenComparatorTest {
    private ArrayList<Accommodatie> accomodaties = new ArrayList<>();
    private Accommodatie accommodatie1 = new Accommodatie("piet", 14.5, 50, 2);
    private Accommodatie accommodatie2 = new Accommodatie("kees", 14.5, 40, 2);
    private Accommodatie accommodatie3 = new Accommodatie("henk", 14.5, 30, 2);
    private Accommodatie accommodatie4 = new Accommodatie("achmed", 14.5, 20, 2);
    private Accommodatie accommodatie5 = new Accommodatie("Rafi", 14.5, 10, 2);

    @Test
    public void comparatortest(){
       accomodaties.add(accommodatie1);
        accomodaties.add(accommodatie2);
        accomodaties.add(accommodatie3);
        accomodaties.add(accommodatie4);
        accomodaties.add(accommodatie5);

        accomodaties.sort(new AantalGastenComparator());
        assertEquals(50, accomodaties.get(4).getAantalGasten());
    }

}
