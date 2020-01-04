package helpers;

import controllers.KlantBewerkController;
import controllers.KlantOverzichtController;
import controllers.MainController;
import models.Klant;
import repositories.*;
import views.BaseView;
import views.KlantOverzichtView;
import views.KlantBewerkView;

import java.io.IOException;

public class StateManager {

    public static final String VIEW_KLANT_OVERZICHT = "KlantOverzicht";
    public static final String VIEW_KLANT_BEWERK = "KlantBewerk";

    private static MainController mainController;

    private static IKlantRepository klantRepository;
    private static Klant huidigeKlant;

    public static void initialize(MainController mainController) {
        StateManager.mainController = mainController;

        //De repository die door de rest van de applicatie gebruikt worden
        klantRepository = new SimulatedKlantRepository();
        //klantRepository = new SerializedKlantRepository();

        try {
            klantRepository.laden();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Standaard scherm
        schakelScherm(VIEW_KLANT_OVERZICHT);
    }

    /**
     * Toon een melding op het scherm
     *
     * @param melding De tekst om te tonen
     */
    public static void toonMelding(String melding) {
        mainController.toonMelding(melding);
    }

    /**
     * Verberg een zichtbare melding
     */
    public static void verbergMelding() {
        mainController.verbergMelding();
    }

    /**
     * Schakel het scherm naar een andere View
     *
     * @param naam Naam van de View
     */
    public static void schakelScherm(String naam) {
        BaseView view;

        switch (naam) {
            case VIEW_KLANT_OVERZICHT:
                view = new KlantOverzichtView(new KlantOverzichtController());
                break;

            case VIEW_KLANT_BEWERK:
                view = new KlantBewerkView(new KlantBewerkController());
                break;

            default:
                return;
        }

        mainController.schakelScherm(view.getRoot());
        mainController.verbergMelding();
    }

    /**
     * @return De actieve repository met klanten
     */
    public static IKlantRepository getKlantRepository() {
        return klantRepository;
    }

    /**
     * @param huidigeKlant De actieve klant
     */
    public static void setHuidigeKlant(Klant huidigeKlant) {
        StateManager.huidigeKlant = huidigeKlant;
    }

    /**
     * @return De actieve klant
     */
    public static Klant getHuidigeKlant() {
        return huidigeKlant;
    }
}
