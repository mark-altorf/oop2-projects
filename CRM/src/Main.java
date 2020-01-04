import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainView;

/**
 * Startpunt van de applicatie
 *
 * @author HvA HBO-ICT
 */
public class Main extends Application {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) {
        MainController mainController = new MainController();
        MainView mainView = new MainView(mainController);

        primaryStage.setTitle(getTitel());
        primaryStage.setScene(new Scene(mainView.getRoot(), WIDTH, HEIGHT));
        primaryStage.show();
    }

    private String getTitel() {
        return "CRM - <Mark Altorf>, <500734051>, <IS202>";
    }

    public static void main(String[] args) {
        launch(args);
    }
}
