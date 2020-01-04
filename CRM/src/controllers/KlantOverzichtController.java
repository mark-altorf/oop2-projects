package controllers;

import helpers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import models.Klant;
import models.Project;
import repositories.SerializedKlantRepository;
import views.KlantOverzichtView;

/**
 * Logica van het KlantOverzicht scherm
 *
 * @author HvA HBO-ICT
 */
public class KlantOverzichtController extends BaseController {

    //--- JavaFX ---
    private ListView<Klant> klantenListView;
    private Label klantInformatieLabel;
    private ListView<Project> projectenListView;
    //--- JavaFX ---

    private ObservableList<Klant> klanten;
    private ObservableList<Project> projecten;

    public void initialize() {
        klanten = FXCollections.observableList(StateManager.getKlantRepository().getAlleKlanten());
        klantenListView.setItems(klanten);

        klantenListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, geselecteerdeKlant) -> {
            if (geselecteerdeKlant == null) {
                return;
            }

            geselecteerdeKlantVeranderd(geselecteerdeKlant);

            if (projecten == null) {
                return;
            }

            sorterenProjectStandaard();
        });

        sorterenKlantStandaard();
    }

    private void geselecteerdeKlantVeranderd(Klant geselecteerdeKlant) {
        //TODO: Implementeer deze methode
        StringBuilder result = new StringBuilder();
        result.append("test");
        result.append("\nregel2");
//    klantInformatieLabel.setText(StringBuilder(geselecteerdeKlant.getVoornaam(),geselecteerdeKlant.getAchternaam(),
//        geselecteerdeKlant.getBedrijfsnaam(),geselecteerdeKlant.getHoogsteFactuurBedrag());
        klantInformatieLabel.setText("Voornaam:" + geselecteerdeKlant.getVoornaam() + "\nAchternaam: " +
                geselecteerdeKlant.getAchternaam() + "\nBedrijfsnaam: " + geselecteerdeKlant.getBedrijfsnaam() +
                "\nHoogste factuurbedrag: " + geselecteerdeKlant.getHoogsteFactuurBedrag());
        projectenListView.setItems(FXCollections.observableList(geselecteerdeKlant.getProjecten()));
    }

    public void klantToevoegen() {
        StateManager.setHuidigeKlant(new Klant());
        StateManager.schakelScherm(StateManager.VIEW_KLANT_BEWERK);
    }

    public void klantBewerken() {
        Klant klant = klantenListView.getSelectionModel().getSelectedItem();

        if (klant == null) {
            StateManager.toonMelding("Er is geen klant geselecteerd!");

            return;
        }

        StateManager.setHuidigeKlant(klant);
        StateManager.schakelScherm(StateManager.VIEW_KLANT_BEWERK);
    }

    public void klantVerwijderen() {
        Klant klant = klantenListView.getSelectionModel().getSelectedItem();

        if (klant == null) {
            StateManager.toonMelding("Er is geen klant geselecteerd!");

            return;
        }

        klanten.remove(klant);
    }

    private void sorterenKlantStandaard() {
        klanten.sort(Klant::compareTo);
    }

    private void sorterenProjectStandaard() {
        projecten.sort(Project::compareTo);
    }

    public void sorterenKlant() {
        //TODO: Implementeer deze methode
        try {
            klanten.sort(new KlantComparator());
            klantenListView.setItems(klanten);
        }catch (Exception e){
            StateManager.toonMelding("Selecteer een klant");
        }
    }

    public void sorterenProject() {
        //TODO: Implementeer deze methode

        Klant klant = klantenListView.getSelectionModel().getSelectedItem();
        projecten = FXCollections.observableList(klant.getProjecten());


        try {
            FXCollections.sort(projecten, new ProjectComparator());
//            projecten.sort(new ProjectComparator());
            projectenListView.setItems(projecten);
        }catch (Exception e){
            StateManager.toonMelding("Selecteer een project");
        }
    }

    public void opslaan() {
        //TODO: Implementeer deze methode
    }

    //--- JavaFX ---
    public void setKlantenListView(ListView<Klant> klantenListView) {
        this.klantenListView = klantenListView;
    }

    public void setKlantInformatieLabel(Label klantInformatieLabel) {
        this.klantInformatieLabel = klantInformatieLabel;
    }

    public void setProjectenListView(ListView<Project> projectenListView) {
        this.projectenListView = projectenListView;
    }
    //--- JavaFX ---
}
