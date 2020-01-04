package helpers;

import models.Klant;

import java.util.Collections;
import java.util.Comparator;

public class KlantComparator implements Comparator<Klant> {
    @Override
    public int compare(Klant o1, Klant o2) {
        return o2.getHoogsteFactuurBedrag() - o1.getHoogsteFactuurBedrag();
    }
}
