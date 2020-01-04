package models;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class KlantTest {

    LocalDate localDate;

    @Test
    public void zonderProjectenTest() {
        Klant klant = new Klant("Hans", "Bergen", "Eco");

//        klant.voegProjectToe(null);

        int result = klant.getHoogsteFactuurBedrag();

        Assert.assertEquals(0, result);
    }

    @Test
    public void metTweeProjectenTest() {
        Klant klant = new Klant("Hans", "Bergen", "Eco");
        String naam = "project";
        int factuurbedrag = 50;
        LocalDate localDate = null;
        Project project = new Project(naam, factuurbedrag, localDate);
        Project project2 = new Project("Projecttwee", 70, localDate);
        klant.voegProjectToe(project);
        klant.voegProjectToe(project2);
        int result = klant.getHoogsteFactuurBedrag();

        Assert.assertEquals(70, result);
    }

}