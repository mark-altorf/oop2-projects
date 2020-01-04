
package nl.hva.mmogear.gearset;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.hva.mmogear.gear.Hammer;
import nl.hva.mmogear.gear.LongSword;

import nl.hva.mmogear.gear.Weapon;
import nl.hva.mmogear.gear.WeaponChest;
import nl.hva.mmogear.gear.dataio.WeaponFileReader;
import nl.hva.mmogear.gear.util.WeaponException;

/**
 *
 * @author <Jouw naam hier!!!>
 */
public class GearSet extends Application {

    private final WeaponChest weaponChest = new WeaponChest(new WeaponFileReader());
    private ObservableList<Weapon> weaponList;

    @Override
    public void start(Stage primaryStage) {

        System.out.println("<Naam> <Achternaam> <Studentnummer>");
                
        // Stap 2
        testStap2();

        
        /* Stap 4 */
                
        //Root of windows
        StackPane root = new StackPane();

        VBox mainBox = new VBox(20);

        //Radio buttons for filtering of weapons
        HBox radioButtonBox = new HBox(20);

        ToggleGroup filterGroup = new ToggleGroup();

        RadioButton allRadioButton = new RadioButton("All");
        allRadioButton.setText("All");
        allRadioButton.setToggleGroup(filterGroup);
        allRadioButton.setLayoutX(100);
        allRadioButton.setLayoutY(0);
        allRadioButton.setSelected(true);

        RadioButton hammerRadioButton = new RadioButton("Hammers");
        hammerRadioButton.setText("Hammers");
        hammerRadioButton.setToggleGroup(filterGroup);
        hammerRadioButton.setLayoutX(25);
        hammerRadioButton.setLayoutY(10);

        RadioButton longSwordRadioButton = new RadioButton("Long Swords");
        longSwordRadioButton.setText("Long Swords");
        longSwordRadioButton.setToggleGroup(filterGroup);

        radioButtonBox.getChildren().addAll(allRadioButton, hammerRadioButton,
                longSwordRadioButton);
        mainBox.getChildren().add(radioButtonBox);

        //Textfields and combobox item
        ComboBox<Weapon> weaponComboBox = new ComboBox<>();
        weaponComboBox.getItems().addAll(new Hammer(), new LongSword());

        Label name = new Label("Name");
        Label rawDamage = new Label("Raw Damage");
        Label elementalDamage = new Label("Elemental Damage");
        Label damage = new Label("Damage");

        TextField nameTextField = new TextField();
        TextField rawDamageTextField = new TextField();
        TextField elementalDamageTextField = new TextField();
        TextField damageTextField = new TextField();

        HBox nameBox = new HBox(20);
        nameBox.getChildren().addAll(name, nameTextField);
        nameBox.setAlignment(Pos.CENTER);
        name.setTranslateX(-38);
        nameTextField.setTranslateX(38);

        HBox rawDamageBox = new HBox(20);
        rawDamageBox.getChildren().addAll(rawDamage, rawDamageTextField);
        rawDamageBox.setAlignment(Pos.CENTER);
        rawDamage.setTranslateX(-16);
        rawDamageTextField.setTranslateX(16);

        HBox elementalDamageBox = new HBox(20);
        elementalDamageBox.getChildren().addAll(elementalDamage,
                elementalDamageTextField);
        elementalDamageBox.setAlignment(Pos.CENTER);
        elementalDamage.setTranslateX(0);
        elementalDamageTextField.setTranslateX(0);

        HBox damageBox = new HBox(20);
        damageBox.getChildren().addAll(damage, damageTextField);
        damageBox.setAlignment(Pos.CENTER);
        damage.setTranslateX(-35);
        damageTextField.setTranslateX(35);

        nameTextField.setPromptText("Weapon name");
        rawDamageTextField.setPromptText("Raw Damage");
        elementalDamageTextField.setPromptText("Elemental Damage");
        damageTextField.setPromptText("Damage");

        nameTextField.setEditable(false);
        rawDamageTextField.setEditable(false);
        elementalDamageTextField.setEditable(false);
        damageTextField.setEditable(false);

        //Button to calculate the total damage of a weapon
        HBox loadBox = new HBox(20);
        
        Button loadButton = new Button();
        loadButton.setText("Load data");

        
        mainBox.getChildren().addAll(weaponComboBox, nameBox, rawDamageBox,
                elementalDamageBox, damageBox);
        
        loadBox.getChildren().addAll(loadButton);
        loadBox.setAlignment(Pos.CENTER);
        loadButton.setTranslateX(-5);
        
        mainBox.getChildren().add(loadBox);
        
        root.getChildren().add(mainBox);
        
        //Voeg hier alle setOnActions functies toe aan de GUI-items.
        loadButton.setOnAction(Event ->{
                                       weaponList = FXCollections.observableList(weaponChest.getAllWeapons());
                                       weaponComboBox.setItems(weaponList);
                                   });
        
        weaponComboBox.setOnAction(event -> {
            damageTextField.setText(Integer.toString(weaponComboBox.getValue().calcDamage()));
            nameTextField.setText(weaponComboBox.getValue().getName());
            elementalDamageTextField.setText(Integer.toString(weaponComboBox.getValue().getElementalDamage()));
            rawDamageTextField.setText(Integer.toString(weaponComboBox.getValue().getRawDamage()));

        });

        hammerRadioButton.setOnAction(event -> {
            weaponList = FXCollections.observableList(weaponChest.getHammers());
            weaponComboBox.setItems(weaponList);

        });

        longSwordRadioButton.setOnAction(event -> {
            weaponList = FXCollections.observableList(weaponChest.getLongSwords());
            weaponComboBox.setItems(weaponList);

        });

        allRadioButton.setOnAction(event -> {
            weaponList = FXCollections.observableList(weaponChest.getAllWeapons());
            weaponComboBox.setItems(weaponList);

        });



        Scene scene = new Scene(root, 400, 320);

        primaryStage.setTitle("Gear set!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    /***
     * 
     * Private helper functie voor het tonen van een alert box
     * @param errorMessage a string containing the message for the user.
     */
    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Internal Error!!!");
        alert.setHeaderText("Information Alert");
        alert.setContentText(errorMessage);
        alert.show();
    }
    
    private Weapon getLS(String name, int raw, int ele) {
        Weapon longSword = new LongSword();
        longSword.setElementalDamage(ele);
        longSword.setRawDamage(raw);
        longSword.setName(name);
        return longSword;
    }
    
    private Weapon getHam(String name, int raw, int ele) {
        Weapon hammer = new Hammer();
        hammer.setElementalDamage(ele);
        hammer.setRawDamage(raw);
        hammer.setName(name);
        return hammer;
    }


    private void testStap2() {
        System.out.println("\n\nStap 2: Lezen van objecten uit de .dat file\n");
        WeaponFileReader weaponReader = new WeaponFileReader();
        List<Weapon> weaponListTest;
        try {
            weaponListTest = weaponReader.readWeaponsFromFile();
            for(Weapon weapon : weaponListTest) {
                System.out.println(weapon);
            }
        } catch (WeaponException ex) {
            Logger.getLogger(GearSet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
