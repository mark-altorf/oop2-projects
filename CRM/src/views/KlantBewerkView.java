package views;

import controllers.KlantBewerkController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.Project;

/**
 * UI van het KlantBewerk scherm
 *
 * @author HvA HBO-ICT
 */
public class KlantBewerkView extends BaseView<KlantBewerkController> {

    private TextField voornaamTextField;
    private TextField achternaamTextField;
    private TextField bedrijfsnaamTextField;


    private TextField projectNaamTextField;
    private TextField projectFactuurbedragTextField;
    private DatePicker projectFactuurdatumDatePicker;

    private ListView<Project> projectenListView;

    private Button klantOpslaanButton;
    private Button projectVerwijderenButton;
    private Button projectToevoegenButton;

    public KlantBewerkView(KlantBewerkController controller) {
        super(controller);
    }

    @Override
    protected Parent createRoot() {
        //Klant
        VBox klantBox = new VBox();
        klantBox.setSpacing(5);

        Label klantLabel = new Label("--- Klant ---");
        klantLabel.setMaxWidth(Double.MAX_VALUE);
        klantLabel.setAlignment(Pos.CENTER);
        klantLabel.setStyle("-fx-font-weight: bold;");

        Label voornaamLabel = new Label("Voornaam:");
        voornaamTextField = new TextField();

        Label achternaamLabel = new Label("Achternaam:");
        achternaamTextField = new TextField();

        Label bedrijfsnaamLabel = new Label("Bedrijfsnaam:");
        bedrijfsnaamTextField = new TextField();

        klantOpslaanButton = new Button("Klant opslaan");

        projectNaamTextField = new TextField();
        projectFactuurbedragTextField = new TextField();
        projectFactuurdatumDatePicker = new DatePicker();

        Label projectNaam = projectNaam = new Label("Projectnaam");
         Label projectFactuurBedrag = new Label("Factuurbedrag:");
         Label projectFactuurBedragDatePicker = new Label("Factuurdatum");

         projectToevoegenButton = new Button("Project toevoegen");


//        klantBox.getChildren().addAll(
//                klantLabel,
//                voornaamLabel,
//                voornaamTextField,
//                achternaamLabel,
//                achternaamTextField,
//                bedrijfsnaamLabel,
//                bedrijfsnaamTextField,
//                klantOpslaanButton,
//                projectNaam,
//                projectNaamTextField,
//                projectFactuurBedrag,
//                projectFactuurbedragTextField,
//                projectFactuurBedragDatePicker,
//                projectFactuurdatumDatePicker
//        );

        //Projecten bewerken
        Label projectenBewerkenLabel = new Label("--- Projecten bewerken ---");
        projectenBewerkenLabel.setMaxWidth(Double.MAX_VALUE);
        projectenBewerkenLabel.setAlignment(Pos.CENTER);
        projectenBewerkenLabel.setStyle("-fx-font-weight: bold;");

        //TODO: Maak dit formulier af...

        klantBox.getChildren().addAll(
                klantLabel,
                voornaamLabel,
                voornaamTextField,
                achternaamLabel,
                achternaamTextField,
                bedrijfsnaamLabel,
                bedrijfsnaamTextField,
                klantOpslaanButton,
                projectenBewerkenLabel,
                projectNaam,
                projectNaamTextField,
                projectFactuurBedrag,
                projectFactuurbedragTextField,
                projectFactuurBedragDatePicker,
                projectFactuurdatumDatePicker,
                projectToevoegenButton
        );

        //Projecten
        VBox projectenBox = new VBox();
        projectenBox.setSpacing(5);

        Label projectenLabel = new Label("--- Projecten ---");
        projectenLabel.setMaxWidth(Double.MAX_VALUE);
        projectenLabel.setAlignment(Pos.CENTER);
        projectenLabel.setStyle("-fx-font-weight: bold;");

        projectenListView = new ListView<>();

        projectVerwijderenButton = new Button("Project verwijderen");

        projectenBox.getChildren().addAll(
            projectenLabel,
            projectenListView,
            projectVerwijderenButton
        );

        //GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(15);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints);

        gridPane.add(klantBox, 0, 0);
        gridPane.add(projectenBox, 1, 0);

        return gridPane;
    }

    @Override
    protected void setupController() {
        controller.setVoornaamTextField(voornaamTextField);
        controller.setAchternaamTextField(achternaamTextField);
        controller.setBedrijfsnaamTextField(bedrijfsnaamTextField);

        controller.setProjectNaamTextField(projectNaamTextField);
        controller.setProjectFactuurbedragTextField(projectFactuurbedragTextField);
        controller.setProjectFactuurdatumDatePicker(projectFactuurdatumDatePicker);

        controller.setProjectenListView(projectenListView);

        klantOpslaanButton.setOnAction(e -> controller.klantOpslaan());
        projectVerwijderenButton.setOnAction(e -> controller.projectVerwijderen());
        projectToevoegenButton.setOnAction(event -> controller.projectToevoegen());
    }
}
