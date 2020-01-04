package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.time.temporal.ChronoUnit.YEARS;

public class Verjaardag implements Serializable {

    private String naam;
    private LocalDate geboorteDatum;

    public Verjaardag(String naam, LocalDate geboorteDatum) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
    }

    public String toString() {
        return geboorteDatum.format(DateTimeFormatter.ofPattern("dd/MM")) + " " + naam + " " + nieuweLeeftijd();
    }

    public LocalDate getVolgendeVerjaardag() {
        return geboorteDatum.plusYears(nieuweLeeftijd());
    }

    private int nieuweLeeftijd() {
        return (int) YEARS.between(geboorteDatum, LocalDate.now().minusDays(1)) + 1;
    }



}
