package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.Kalender;
import view.Scherm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JavaFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final Kalender kalender;
    private final Scherm scherm;

    public JavaFxApplication() {
        this.scherm = new Scherm(this);
        this.kalender = new Kalender("kalender.dat");
    }

    public void start(Stage primaryStage) {
        System.out.println("Mark Altorf, 500734051 ");
        scherm.setVerjaardagenListViewItems(kalender.sorteerEnGetVerjaardagen());
        Scene scene = new Scene(scherm, 300, 350);
        primaryStage.setTitle("JavaFxApplication");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            try {
                kalender.bewaar();
            } catch (Exception ex) {
                showErrorMessage(ex.getMessage());
            }
        });
        primaryStage.show();
    }

    public void voegVerjaardagToe() {
        try {
            kalender.voegToe(scherm.getNaam(),convertStringsToCalender(scherm.getDag(),scherm.getMaand(),scherm.getJaar()));
        } catch (DateTimeParseException e){
            showErrorMessage(e.getMessage());
        }
        scherm.setVerjaardagenListViewItems(kalender.sorteerEnGetVerjaardagen());
    }

    private LocalDate convertStringsToCalender(String dag, String maand, String jaar) throws DateTimeParseException {
        return LocalDate.parse(jaar + "/" + maand + "/" + dag, DateTimeFormatter.ofPattern("y/M/d"));
    }

    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("De volgende fout is opgetreden:");
        alert.setContentText(errorMessage);
        alert.show();
    }
}
