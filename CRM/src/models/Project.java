package models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Project
 *
 * @author HvA HBO-ICT
 */
public class Project implements Comparable<Project>, Serializable {

    private String naam;
    private int factuurBedrag;
    private LocalDate factuurDatum;

    public Project(Project project) {
        this(project.getNaam(), project.getFactuurBedrag(), project.getFactuurDatum());
    }

    public Project(String naam, int factuurBedrag, LocalDate factuurDatum) {
        this.naam = naam;
        this.factuurBedrag = factuurBedrag;
        this.factuurDatum = factuurDatum;
    }

    public String getNaam() {
        return naam;
    }

    public int getFactuurBedrag() {
        return factuurBedrag;
    }

    public LocalDate getFactuurDatum() {
        return factuurDatum;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %,d euro", factuurDatum, naam, factuurBedrag);
    }

    @Override
    public int compareTo(Project project) {
        return project.getFactuurDatum().compareTo(factuurDatum);
    }
}
