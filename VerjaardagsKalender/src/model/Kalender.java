package model;

import data.Bestand;
import util.Fout;
import util.Volgorde;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kalender {

    private Bestand bestand;
    private List<Verjaardag> verjaardagen;

    public Kalender(String filenaam) {
        this.bestand = new Bestand(filenaam);
        try {
verjaardagen = bestand.leesTerug();
        }catch (Fout f){
            System.out.println(f.getMessage());
            verjaardagen = new ArrayList<Verjaardag>();
        }
    }

    public void voegToe(String naam, LocalDate geboorteDatum) {
        verjaardagen.add(new Verjaardag(naam, geboorteDatum));
    }

    public List<Verjaardag> sorteerEnGetVerjaardagen() {
verjaardagen.sort(new Volgorde());
        return verjaardagen;
    }

    public void bewaar() throws Fout {
        bestand.schrijfWeg(verjaardagen);
    }
}
