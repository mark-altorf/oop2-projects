package repositories;

import helpers.KlantException;
import models.Klant;
import models.Project;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *  Een gesimuleerde versie van de klant repository voor testdoeleinden
 *
 * @author HvA HBO-ICT
 */
public class SimulatedKlantRepository implements IKlantRepository {

    private final String[] KLANT_NAMEN = {
            "Huug Koninenbeld",
            "Robert-Jan Haverkate",
            "Jurian van de Vuurst",
            "Robbert Bongers",
            "Jan-Bart Nijenbijvank",
            "Daan Krabbenbos",
            "Alie Stevens toeters",
            "Hubrecht Ymhof",
            "Julian Christenhusz",
            "Jan-Bart Bargboer",
            "Heleen Buitink",
            "Dineke Kleinroseboom",
            "Dieneke Vrohuis",
            "Marjolijn Ezendam",
            "Joosje van Oldeniel",
            "Jooske bij Braakjans",
            "Marijntje Willinkvoorde",
            "Aafke Donninger",
            "Marlien Mestebeld",
            "Maartje Vlogtman"
    };

    private final String[] BEDRIJFS_NAMEN = {
            "TechDevelopment",
            "Aptics",
            "ICTG",
            "Webel",
            "TechCamel",
            "WebTech.io",
            "Resoft",
            "Enhant",
            "NREND",
            "wiPRO",
            "Ebeat",
            "LogicBotics",
            "SectorStack",
            "Upzone",
            "ICTbay"
    };

    private final String[] PROJECT_NAMEN = {
            "Ghastly Flag",
            "Deserted Grotesque Hammer",
            "Obscure Northernmost",
            "Late Xylophone",
            "Needless Yard",
            "Accidentally Knife",
            "Trendy Nervous",
            "New Lion",
            "Rocky Torpedo",
            "Donut Freaky",
            "Eagle Steamy",
            "Western Morning",
            "Pottery Scattered",
            "Late Snake",
            "Straw Skunk",
            "Risky Angry Cat",
            "Lucky Finger",
            "Big Wrench",
            "Scissors Solid",
            "Icy Metaphor"
    };

    final int AANTAL_PROJECTEN_PER_KLANT = 15;

    private ArrayList<Klant> klanten;

    public SimulatedKlantRepository() {
        klanten = new ArrayList<>();
    }

    @Override
    public ArrayList<Klant> getAlleKlanten() {
        return klanten;
    }

    public void laden() {
        for(int i = 0; i < KLANT_NAMEN.length; i++) {
            Klant klant = new Klant(
                    KLANT_NAMEN[i].substring(0, KLANT_NAMEN[i].indexOf(' ')),
                    KLANT_NAMEN[i].substring(KLANT_NAMEN[i].indexOf(' ') + 1),
                    BEDRIJFS_NAMEN[i % BEDRIJFS_NAMEN.length]
            );

            for(int i2 = 0; i2 < AANTAL_PROJECTEN_PER_KLANT; i2++) {
                Project project = new Project(
                        PROJECT_NAMEN[(i + (i2 * AANTAL_PROJECTEN_PER_KLANT)) * 3 % PROJECT_NAMEN.length],
                        (((i + i2 * 3) * 1_000) % 100_000) + (((i + 1) * (i2 + 1) + i + i2 * 10) % 10_000),
                        LocalDate.of(
                                2019,
                                ((i * 3 + i2 * 2) % 11) + 1,
                                ((i * 15 + i2 * 15) % 27) + 1)
                );

                klant.voegProjectToe(project);
            }

            klanten.add(klant);
        }
    }

    public void opslaan() throws KlantException {
        throw new KlantException("Gesimuleerde data kan niet worden opgeslagen!");
    }
}
