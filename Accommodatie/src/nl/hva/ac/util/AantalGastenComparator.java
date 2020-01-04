package nl.hva.ac.util;

import nl.hva.ac.model.Accommodatie;

import java.util.Comparator;

public class AantalGastenComparator implements Comparator<Accommodatie> {
    @Override
    public int compare(Accommodatie o1, Accommodatie o2) {
        return o1.getAantalGasten() - o2.getAantalGasten();
    }
}
