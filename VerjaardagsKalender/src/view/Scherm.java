package view;

import controller.JavaFxApplication;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Verjaardag;

import java.util.List;

import static javafx.collections.FXCollections.observableList;

public class Scherm extends GridPane {

    private TextField naamTextField;
    private TextField dagTextField;
    private TextField maandTextField;
    private TextField jaarTextField;
    private Button voegToeButton;
    private ListView<Verjaardag> verjaardagenListView;

    public Scherm(JavaFxApplication myController) {
        this.naamTextField = new TextField();
        this.dagTextField = new TextField();
        this.maandTextField = new TextField();
        this.jaarTextField = new TextField();
        this.voegToeButton = new Button("Voeg toe");
        this.verjaardagenListView = new ListView<>();
        initLayout();

        voegToeButton.setId("Voeg toe");
        voegToeButton.setOnAction(Event ->{
            myController.voegVerjaardagToe();

        });
    }

    public String getNaam() {
        return naamTextField.getText();
    }

    public String getDag() {
        return dagTextField.getText();
    }

    public String getMaand() {
        return maandTextField.getText();
    }

    public String getJaar() {
        return jaarTextField.getText();
    }
    
    public void setVerjaardagenListViewItems(List<Verjaardag> verjaardagen) {
        verjaardagenListView.setItems(observableList(verjaardagen));
    }

    private void initLayout() {
        add(new Label(" Naam  "), 1, 1);
        add(naamTextField, 2, 1);
        add(new Label(" Dag   "), 1, 2);
        add(dagTextField, 2, 2);
        add(new Label(" Maand "), 1, 3);
        add(maandTextField, 2, 3);
        add(new Label(" Jaar  "), 1, 4);
        add(jaarTextField, 2, 4);
        add(verjaardagenListView, 2, 6);
        add(voegToeButton,2,5);}
}
