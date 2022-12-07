package com.example.symulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class wydajAlbumController implements Initializable {
    @FXML public Pane panel_tlo;
    @FXML public Button przycisk_akceptuj;
    @FXML public Button przycisk_powrot;
    @FXML public TextField pole_ilosc;

    @FXML
    public void akceptujAction(ActionEvent actionEvent) {
        int koszt = Integer.parseInt(pole_ilosc.getText())*500;


    }

    @FXML
    public void powrotAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
