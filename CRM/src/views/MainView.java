package views;

import controllers.MainController;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

/**
 * UI van het hoofdscherm
 *
 * @author HvA HBO-ICT
 */
public class MainView extends BaseView<MainController> {
    private BorderPane borderPane;
    private Label melding;

    private MenuItem toonKlantenMenuItem;
    private MenuItem afsluitenMenuItem;

    public MainView(MainController controller) {
        super(controller);
    }

    protected Parent createRoot() {
        //CRM-menu
        Menu crmMenu = new Menu("CRM");

        toonKlantenMenuItem = new MenuItem("Toon alle klanten");

        afsluitenMenuItem = new MenuItem("Afsluiten");

        crmMenu.getItems().addAll(
                toonKlantenMenuItem,
                new SeparatorMenuItem(),
                afsluitenMenuItem
        );

        //Menubalk
        MenuBar menuBar = new MenuBar(crmMenu);

        //Melding
        melding = new Label();
        melding.setStyle("-fx-background-color: bisque");
        melding.setMaxWidth(Double.MAX_VALUE);
        melding.setPadding(new Insets(15, 15, 15, 15));

        //Borderpane
        borderPane = new BorderPane();
        borderPane.setTop(melding);

        BorderPane rootBorderPane = new BorderPane();
        rootBorderPane.setTop(menuBar);
        rootBorderPane.setCenter(borderPane);

        return rootBorderPane;
    }

    protected void setupController() {
        controller.setMelding(melding);
        controller.setBorderPane(borderPane);

        toonKlantenMenuItem.setOnAction(e -> controller.toonKlanten());
        afsluitenMenuItem.setOnAction(e -> controller.afsluiten());
    }
}
