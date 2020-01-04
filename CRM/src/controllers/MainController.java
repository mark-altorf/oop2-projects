package controllers;

import helpers.StateManager;
import javafx.scene.Parent;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Logica van het hoofdscherm
 *
 * @author HvA HBO-ICT
 */
public class MainController extends BaseController {

    // --- JavaFX ---
    private Label melding;
    private BorderPane borderPane;
    // --- JavaFX ---

    @Override
    public void initialize() {
        StateManager.initialize(this);
    }

    public void toonKlanten() {
        StateManager.schakelScherm(StateManager.VIEW_KLANT_OVERZICHT);
    }

    public void afsluiten() {
        System.exit(0);
    }

    public void schakelScherm(Parent root) {
        borderPane.setCenter(root);
    }

    public void toonMelding(String text) {
        melding.setPrefHeight(Control.USE_COMPUTED_SIZE);
        melding.setText(text);
    }

    public void verbergMelding() {
        melding.setMinHeight(0);
        melding.setPrefHeight(0);
    }

    // --- JavaFX ---
    public void setMelding(Label melding) {
        this.melding = melding;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }
    // --- JavaFX ---
}
