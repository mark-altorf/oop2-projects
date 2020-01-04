package util;

import model.Verjaardag;

import java.util.Comparator;

public class Volgorde implements Comparator<Verjaardag> {

    public int compare(Verjaardag o1, Verjaardag o2) {

            return o1.getVolgendeVerjaardag().compareTo(o2.getVolgendeVerjaardag());
    }
}
