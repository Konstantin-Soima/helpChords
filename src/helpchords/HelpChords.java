/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpchords;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author konstantin.soyma
 */
public class HelpChords extends Application {

    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
         btn.setText("Say 'Hello World'");
         btn.setOnAction(new EventHandler<ActionEvent>() {
            
         @Override
         public void handle(ActionEvent event) {
         System.out.println("Hello World!");
         }
         });
         */
        Label lCntStr = new Label("Количество струн");
        lCntStr.setLayoutX(10);
        final ComboBox cbStringsCount = new ComboBox(FXCollections.observableArrayList(
                "3", "4", "5", "6", "7", "8", "9", "10", "11"
        ));
        cbStringsCount.setLayoutX(150);

        Label lChrd = new Label("Аккорд");
        lChrd.setLayoutX(220);
        final ComboBox cbChordName = new ComboBox(FXCollections.observableArrayList(
                "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"
        ));
        cbChordName.setLayoutX(280);

        Label lSuff = new Label("Суффикс");
        lSuff.setLayoutX(350);
        final ComboBox cbChordSuffix = new ComboBox(FXCollections.observableArrayList(
                "", "5", "sus4", "sus2", "add9", "6", "6/9", "maj7", "maj9", "maj7#11", "maj13", "m", "m(add9)", "m6", "mb6", "m6/9", "m7", "m7b5", "m9", "m11", "m13", "7", "7sus4", "9", "9sus4", "11", "13", "13sus4", "*"
        ));
        cbChordSuffix.setLayoutX(420);
        
        Button bMake = new Button("Построить");
        
        Group root = new Group();
        root.getChildren().addAll(lCntStr, cbStringsCount, lChrd, cbChordName, lSuff, cbChordSuffix);
        Scene scene = new Scene(root, 640, 480);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    String[] tones = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};

    public String GetTonePlus(String tone, int plus) {
        int intTone=0;
        for (int i = 0; i < tones.length; i++) {
            if (tones[i] == tone) {
                intTone = i;
            }
        }
        int newTone = (intTone+plus)%tones.length;
        return tones[newTone];
    }

    public String[] NotesFromChord(String note, String sufix) { //Ноты в аккорде
        switch (sufix) {
            case (""):
                return new String[]{note,GetTonePlus(note,4),GetTonePlus(note,7)};
                
        }
        return new String []{"Error"};
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
