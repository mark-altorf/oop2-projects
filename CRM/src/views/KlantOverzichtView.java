package views;

import controllers.KlantOverzichtController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.Klant;
import models.Project;

/**
 * UI van het KlantOverzicht scherm
 *
 * @author HvA HBO-ICT
 */
public class KlantOverzichtView extends BaseView<KlantOverzichtController> {

    private ListView<Klant> klantenListView;
    private Label klantInformatieLabel;
    private ListView<Project> projectenListView;
    private Button klantToevoegenButton;
    private Button klantBewerkenButton;
    private Button klantVerwijderenButton;
    private Button sorterenKlantButton;
    private Button sorterenProjectButton;
    private Button opslaanButton;

    public KlantOverzichtView(KlantOverzichtController controller) {
        super(controller);
    }

    @Override
    protected Parent createRoot() {
        //Klanten
        Label klantenLabel = new Label("-- Klanten --");
        klantenLabel.setMaxWidth(Integer.MAX_VALUE);
        klantenLabel.setMinHeight(30);
        klantenLabel.setAlignment(Pos.CENTER);
        klantenLabel.setStyle("-fx-font-weight: bold;");

        klantenListView = new ListView<>();

        //Klant informatie
        Label geselecteerdeKlantLabel = new Label("-- Geselecteerde klant --");
        geselecteerdeKlantLabel.setMaxWidth(Integer.MAX_VALUE);
        geselecteerdeKlantLabel.setMinHeight(30);
        geselecteerdeKlantLabel.setAlignment(Pos.CENTER);
        geselecteerdeKlantLabel.setStyle("-fx-font-weight: bold;");

        klantInformatieLabel = new Label("Er is geen klant geselecteerd!");
        klantInformatieLabel.setMinHeight(70);

        Label projectenLabel = new Label("Projecten:");
        projectenLabel.setMinHeight(30);

        projectenListView = new ListView<>();

        VBox klantInformatieBox = new VBox(klantInformatieLabel, projectenLabel, projectenListView);

        VBox.setVgrow(projectenListView, Priority.ALWAYS);

        //Knoppen
        Label sorterenLabel = new Label("Sorteren:");
        sorterenLabel.setMinHeight(25);
        sorterenLabel.setAlignment(Pos.CENTER);

        klantToevoegenButton = new Button("Klant toevoegen");
        klantBewerkenButton = new Button("Klant bewerken");
        klantVerwijderenButton = new Button("Klant verwijderen");
        sorterenKlantButton = new Button("Klant");
        sorterenProjectButton = new Button("Project");
        opslaanButton = new Button("Opslaan");

        HBox knoppenBox = new HBox(
                klantToevoegenButton,
                klantBewerkenButton,
                klantVerwijderenButton,
                opslaanButton,
                sorterenLabel,
                sorterenKlantButton,
                sorterenProjectButton
        );

        knoppenBox.setPadding(new Insets(15, 0, 0, 0));
        knoppenBox.setSpacing(15);

        //Gridpane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(15);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);

        gridPane.getColumnConstraints().addAll(columnConstraints, columnConstraints);

        GridPane.setVgrow(klantenListView, Priority.ALWAYS);

        gridPane.add(klantenLabel, 0, 0);
        gridPane.add(klantenListView, 0, 1);
        gridPane.add(geselecteerdeKlantLabel, 1, 0);
        gridPane.add(klantInformatieBox, 1, 1);

        //Borderpane
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(15, 15, 15, 15));
        borderPane.setCenter(gridPane);
        borderPane.setBottom(knoppenBox);

        return borderPane;
    }

    @Override
    protected void setupController() {
        controller.setKlantenListView(klantenListView);
        controller.setKlantInformatieLabel(klantInformatieLabel);
        controller.setProjectenListView(projectenListView);

        klantToevoegenButton.setOnAction(e -> controller.klantToevoegen());
        klantBewerkenButton.setOnAction(e -> controller.klantBewerken());
        klantVerwijderenButton.setOnAction(e -> controller.klantVerwijderen());
        sorterenKlantButton.setOnAction(e -> controller.sorterenKlant());
        sorterenProjectButton.setOnAction(e -> controller.sorterenProject());
        opslaanButton.setOnAction(e -> controller.opslaan());
    }
}
