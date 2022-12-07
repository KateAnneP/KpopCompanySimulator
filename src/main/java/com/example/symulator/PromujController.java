package com.example.symulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PromujController implements Initializable {


    @FXML public Button przycisk_powrot;
    @FXML public Button przycisk_reklama;
    @FXML public Button przycisk_music_show;
    @FXML public Button prycisk_wywiad;
    @FXML public Button przycisk_radio;
    @FXML public Pane panel_tlo;

    @FXML
    public void radioAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void wywiadAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void musicShowAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void reklamaAction(ActionEvent event) throws IOException {


    }

    public void powrot(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }


    @Override
    public void initialize (URL url, ResourceBundle rb)
    {

    }



}
