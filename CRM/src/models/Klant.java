package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klant
 *
 * @author HvA HBO-ICT
 */
public class Klant implements Comparable<Klant>, Serializable {

    private String voornaam;
    private String achternaam;
    private String bedrijfsnaam;
    private List<Project> projecten;

    public Klant() {
        this("", "", "");
    }

    public Klant(Klant klant) {
        this(klant.getVoornaam(), klant.getAchternaam(), klant.getBedrijfsnaam());

        for(Project project : klant.getProjecten()) {
            voegProjectToe(new Project(project));
        }
    }

    public Klant(String voornaam, String achternaam, String bedrijfsnaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.bedrijfsnaam = bedrijfsnaam;

        projecten = new ArrayList<>();
    }



    public int getHoogsteFactuurBedrag() {
        int hoogstebedrag = 0;

        for (Project project : projecten ) {
            if (project.getFactuurBedrag() >  hoogstebedrag) {
                hoogstebedrag = project.getFactuurBedrag();
            }
        }

        return hoogstebedrag;
//        return projecten.get(0).getFactuurBedrag();

    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public void voegProjectToe(Project project) {
        projecten.add(project);
    }

    public List<Project> getProjecten() {
        return projecten;
    }

    @Override
    public String toString() {
        return voornaam + " " + achternaam + " (" + bedrijfsnaam + ")";
    }

    @Override
    public int compareTo(Klant o) {
        String naam1 = getVoornaam() + " " + getAchternaam();
        String naam2 = o.getVoornaam() + " " + o.getAchternaam();

        return naam1.compareTo(naam2);
    }
}
