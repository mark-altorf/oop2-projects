package nl.hva.ac.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import nl.hva.ac.model.Accommodatie;

/**
 * Pane om accommodaties te laten zien. Deze pane bevat een Scrollpane die een
 * lijst {@link nl.hva.ac.model.Accommodatie} kan bevatten en twee buttons.
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class AccommodatiesPane extends GridPane {

    private static final int BTN_HEIGHT = 40;
    private final static int BTN_WIDTH = 260;
    private final ListView<Accommodatie> lvAccommodaties;

    /**
     *
     * Maakt een nieuwe AccommodatiesPane aan.
     *
     */
    public AccommodatiesPane() {
        this.setAlignment(Pos.CENTER);
        this.setHgap(15);
        this.setVgap(15);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.lvAccommodaties = new ListView<>();
        init();
    }

    public ObservableList<Accommodatie> getAccommodatieItems(){
        return this.lvAccommodaties.getItems();
    }
    
    public void setAccommodatieItems(ObservableList<Accommodatie> accommodatieItems) {
        this.lvAccommodaties.setItems(accommodatieItems);
    }

    private void init() {
        //init ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMinWidth(BTN_WIDTH);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(lvAccommodaties);

        Button button = new Button("Sorteer");
        button.setId("Sorteer");

        Button buttonOpslaan = new Button("Opslaan");
        buttonOpslaan.setId("Opslaan");

        this.add(new Label(), 0, 1);
        this.add(scrollPane, 0, 2);
        this.add(button,0,4);
        this.add(buttonOpslaan,0,5);

    }

}
