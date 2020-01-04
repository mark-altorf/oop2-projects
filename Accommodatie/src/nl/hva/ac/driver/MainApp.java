package nl.hva.ac.driver;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import nl.hva.ac.controller.AccommodatieController;
import nl.hva.ac.view.AccommodatiesPane;

/**
 * Driver voor Accommodatie applicatie.
 *
 * @author Folkert Boonstra <F.K.Boonstra@hva.nl>
 */
public class MainApp extends Application {

    private final static int SCENE_WIDTH = 300;
    private final static int SCENE_HEIGHT = 400;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        AccommodatiesPane accommodatiesPane = new AccommodatiesPane();
        Scene scene = new Scene(accommodatiesPane, SCENE_WIDTH, SCENE_HEIGHT);
        AccommodatieController controller = new AccommodatieController(accommodatiesPane);
        //initialiseer de pane met accommodaties
        accommodatiesPane.setAccommodatieItems(controller.getAccommodatieData());

        this.stage.setTitle("Accommodaties");
        this.stage.setScene(scene);
        
        this.stage.setOnCloseRequest((new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                event.consume();
                stop();
            }
        }));

        this.stage.setWidth(SCENE_WIDTH);
        this.stage.setHeight(SCENE_HEIGHT);
        this.stage.show();
    }

    /**
     * Stopt de applicatie.
     */
    @Override
    public void stop() {
        try {
            Platform.exit();
        } catch (Exception ex) {
            System.out.print(ex.getMessage() + "\r\n");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(getLastNameAndStudentNumber());
        launch(args);
    }
    
     public static String getLastNameAndStudentNumber() {

        return "Altorf, 500734051";
    } 

}
