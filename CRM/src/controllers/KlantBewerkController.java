package controllers;

import helpers.StateManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Klant;
import models.Project;

import java.time.LocalDate;

/**
 * Logica van het KlantBewerk scherm
 *
 * @author HvA HBO-ICT
 */
public class KlantBewerkController extends BaseController {

    //--- JavaFX ---
    public TextField voornaamTextField;
    public TextField achternaamTextField;
    public TextField bedrijfsnaamTextField;

    public TextField projectNaamTextField;
    public TextField projectFactuurbedragTextField;
    public DatePicker projectFactuurdatumDatePicker;

    private ListView<Project> projectenListView;
    //--- JavaFX ---

    private Klant huidigeKlant;
    private ObservableList<Project> projecten;

    public void initialize() {
        huidigeKlant = new Klant(StateManager.getHuidigeKlant());

        voornaamTextField.setText(huidigeKlant.getVoornaam());
        achternaamTextField.setText(huidigeKlant.getAchternaam());
        bedrijfsnaamTextField.setText(huidigeKlant.getBedrijfsnaam());

        projecten = FXCollections.observableList(huidigeKlant.getProjecten());
        projectenListView.setItems(projecten.sorted());
    }

    public void klantOpslaan() {
        huidigeKlant.setVoornaam(voornaamTextField.getText());
        huidigeKlant.setAchternaam(achternaamTextField.getText());
        huidigeKlant.setBedrijfsnaam(bedrijfsnaamTextField.getText());

        StateManager.getKlantRepository().getAlleKlanten().remove(StateManager.getHuidigeKlant());
        StateManager.getKlantRepository().getAlleKlanten().add(huidigeKlant);

        StateManager.schakelScherm(StateManager.VIEW_KLANT_OVERZICHT);
    }

    public void projectToevoegen() {
        //TODO: Implementeer deze methode
        Project project;
       String naam = projectNaamTextField.getText();
       int projectFactuur = Integer.parseInt(projectFactuurbedragTextField.getText());
       LocalDate datepicker = projectFactuurdatumDatePicker.getValue();

       if (naam.trim().isEmpty() || naam == null){
           StateManager.toonMelding("Naam is niet geldig");
       }

       if (projectFactuur <= 0 || projectFactuurbedragTextField.getText().trim().isEmpty() || projectFactuurbedragTextField.getText().equals(0)){
           StateManager.toonMelding("Factuurbedrag is niet geldig");
       }
       if (datepicker == null || projectFactuurdatumDatePicker.getValue().equals(null)){
           StateManager.toonMelding("Kies een geldige datum");
       }

       project = new Project(naam, projectFactuur, datepicker);

       projecten.add(project);

       projectNaamTextField.setText("");
       projectFactuurbedragTextField.setText("");
       projectFactuurdatumDatePicker.setValue(null);
    }

    public void projectVerwijderen() {
        Project project = projectenListView.getSelectionModel().getSelectedItem();

        if(project == null) {
            StateManager.toonMelding("Er is geen project geselecteerd!");

            return;
        }

        projecten.remove(project);
    }

    //--- JavaFX ---
    public void setVoornaamTextField(TextField voornaamTextField) {
        this.voornaamTextField = voornaamTextField;
    }

    public void setAchternaamTextField(TextField achternaamTextField) {
        this.achternaamTextField = achternaamTextField;
    }

    public void setBedrijfsnaamTextField(TextField bedrijfsnaamTextField) {
        this.bedrijfsnaamTextField = bedrijfsnaamTextField;
    }

    public void setProjectNaamTextField(TextField projectNaamTextField) {
        this.projectNaamTextField = projectNaamTextField;
    }

    public void setProjectFactuurbedragTextField(TextField projectFactuurbedragTextField) {
        this.projectFactuurbedragTextField = projectFactuurbedragTextField;
    }

    public void setProjectFactuurdatumDatePicker(DatePicker projectFactuurdatumDatePicker) {
        this.projectFactuurdatumDatePicker = projectFactuurdatumDatePicker;
    }

    public void setProjectenListView(ListView<Project> projectenListView) {
        this.projectenListView = projectenListView;
    }
    //--- JavaFX ---
}
