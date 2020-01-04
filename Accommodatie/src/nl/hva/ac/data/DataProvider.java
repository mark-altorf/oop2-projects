package nl.hva.ac.data;

import java.util.ArrayList;
import java.util.List;
import nl.hva.ac.model.Accommodatie;

/**
 * Geeft een vaste lijst van accommodaties.
 * 
 * @author michel.mercera
 */
public class DataProvider {

    public List<Accommodatie> getDummyAccommodatieData() {
        ArrayList<Accommodatie> accommodaties = new ArrayList();
        accommodaties.add(new Accommodatie("Formule 1", 29.99, 5, 2));
        accommodaties.add(new Accommodatie("Hilton", 440.0, 3, 2));
        accommodaties.add(new Accommodatie("De Aap", 9.99, 7,2 ));
        return accommodaties;
    }
}
