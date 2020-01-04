package nl.hva.ac.model;

import nl.hva.ac.util.IllegaleAccommodatieException;

import java.io.Serializable;

/**
 * Accommodatie
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class Accommodatie implements Serializable {

    private final String naam;
    private final double prijs;
    private int aantalGasten;
    private final int aantalNachten;
    private boolean bevestigd;

    /**
     * Maak een acommodatie.
     *
     * @param naam          naam van de accommodatie.
     * @param prijs         prijs van een accommodatie per nacht.
     * @param aantalGasten  aantal gasten die van de accommodatie gebruik gaan maken.
     * @param aantalNachten aantal nachten dat de accomodatie wordt verhuurd.
     */
    public Accommodatie(String naam, double prijs, int aantalGasten, int aantalNachten) {
        this.naam = naam;
        this.prijs = prijs;
        this.aantalGasten = aantalGasten;
        this.aantalNachten = aantalNachten;
        this.bevestigd = false;
    }

    public int getAantalGasten() {
        return aantalGasten;
    }

    public void setAantalGasten(int aantalGasten) {
        this.aantalGasten = aantalGasten;
    }

    @Override
    public String toString() {
        return String.format("%-12s  %-8s %-8s  %-5s", this.naam, this.prijs, this.aantalGasten, this.bevestigd);
    }

    public void bevestig() throws IllegaleAccommodatieException {
        if (naam.trim().isEmpty() || prijs < 0 || aantalGasten < 1 || aantalNachten < 1) {
            throw new IllegaleAccommodatieException("Naam, prijs, aantalgasten of aantalnachten is fout");
        } else {
            bevestigd = true;
        }

    }


}
