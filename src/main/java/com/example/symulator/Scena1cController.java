package com.example.symulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Scena1cController implements Initializable {

    @FXML public Button przycisk_powrot;
    @FXML public Button przycisk_dalej;
    @FXML public TextField pole_nick;
    @FXML public PasswordField pole_haslo;

    Mysql uzytkownik = MainApplication.getInstance().getSql();

    public static String haslo;
    public static String nick;
    public int id = 0;

    public static int numer = 0;

    @FXML
    public void zatwierdzAction(ActionEvent event) throws IOException {
        nick = pole_nick.getText();
        haslo = pole_haslo.getText();
        numer = 2;
        try {
            ResultSet wynik = uzytkownik.getResult("SELECT id FROM users WHERE nick='" + nick + "' AND haslo='" + haslo + "';");
            wynik.next();
            System.out.println("ID usera:" + wynik.getInt("id"));
            id = wynik.getInt("id");
            if (id != 0) {
                System.out.println("Prawidłowe dane");
                Parent root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Kpop company owner SIMULATOR");
                scene.getStylesheets().add("symulator.css");
                stage.show();
            }
        }
        catch (SQLException e)
        {
            System.out.println("Nieprawidłowe dane!!!");
        }

    }


    @FXML
    public void powrotAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
