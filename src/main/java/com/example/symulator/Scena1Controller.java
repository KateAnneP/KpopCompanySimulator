package com.example.symulator;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scena1Controller implements Initializable {

    @FXML public Button przycisk_nowa_gra;
    @FXML public Button przycisk_zaladuj_gre;
    @FXML public Button przycisk_zamknij;


    @FXML
    public void przelaczNaScene1b(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scena1b.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @FXML
    public void przelaczNaScene1c(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scena1c.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @FXML
    public void zamknijAplikacjeAction(ActionEvent actionEvent) {
        Platform.exit();
    }



    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }



}