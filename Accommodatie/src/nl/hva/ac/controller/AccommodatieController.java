package nl.hva.ac.controller;

import java.awt.*;
import java.io.*;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import nl.hva.ac.data.DataProvider;
import nl.hva.ac.model.Accommodatie;
import nl.hva.ac.util.AantalGastenComparator;
import nl.hva.ac.view.AccommodatiesPane;

/**
 * De AccommodatieController.
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class AccommodatieController {

    private final AccommodatiesPane accommodatiesPane;

    public AccommodatieController(Pane accommodatiesPane) {
        if (accommodatiesPane instanceof AccommodatiesPane) {
            this.accommodatiesPane = (AccommodatiesPane) accommodatiesPane;
        } else {
            this.accommodatiesPane = null;
        }

        init();

    }

    //Voeg hier de acties toe aan de buttons in accommodatiesPane.
    private void init() {

        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSort = (Button) this.accommodatiesPane.lookup("#Sorteer");

        //TODO uncomment de code hieronder om je aangemaakte button te vinden
        Button btnSave = (Button) this.accommodatiesPane.lookup("#Opslaan");

        btnSort.setOnAction(Event -> {
            ObservableList<Accommodatie> ol = getAccommodatieData();
            ol.sort(new AantalGastenComparator());
            accommodatiesPane.setAccommodatieItems(ol);

        });

        btnSave.setOnAction(Event -> {
            saveData();
        });

    }


    /**
     * Vraag de lijst met accommodaties op.
     *
     * @return een observable lijst van accommodaties.
     */
    public ObservableList<Accommodatie> getAccommodatieData() {
        DataProvider dataProvider = new DataProvider();
        List accommList = dataProvider.getDummyAccommodatieData();
        ObservableList<Accommodatie> accommFXList = FXCollections.observableArrayList(accommList);
        return accommFXList;
    }

    public void saveData() {
        DataProvider dataProvider = new DataProvider();
        List accommList = dataProvider.getDummyAccommodatieData();
        try {
            File outputFile = new File("accommodaties.dat");
            FileOutputStream fos = new FileOutputStream(outputFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream ops = new ObjectOutputStream(bos);
            ops.writeObject(accommList);
            ops.close();

        } catch (IOException e) {
            System.out.println("Er was een fout opgetreden");
        }
    }

}
