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
import java.util.ResourceBundle;

public class Scena1bController implements Initializable {

    public static String haslo;
    public static String nick;
    private static Double money;
    private static int dni_od_startu;
    public static Boolean pierwszy = true;

    public static int numer = 0;

    @FXML public TextField pole_nick;
    @FXML public PasswordField pole_haslo;
    @FXML public Button przycisk_powrot;
    @FXML public Button przycisk_dalej;

    @FXML
    public void zatwierdzAction(ActionEvent event) throws IOException {
        haslo = pole_haslo.getText();
        nick = pole_nick.getText();
        setMoney(10000.00);
        setDni_od_startu(1);
        numer = 1;
        uzytkownik.update("INSERT INTO `users`(`nick`,`haslo`,`fundusze`,`dni`) VALUES ('"+nick+"','"+haslo+"','"+money+"','"+dni_od_startu+"');");

        Parent root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    Mysql uzytkownik = MainApplication.getInstance().getSql();


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

    public String getNick(String nick)
    {
        this.nick = pole_nick.getText();
        return nick;
    }

    public String getHaslo(String haslo)
    {
        this.haslo = pole_haslo.getText();
        return haslo;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getDni_od_startu()
    {
        return dni_od_startu;
    }

    private void setDni_od_startu(int dni_od_startu)
    {
        this.dni_od_startu = dni_od_startu;
    }

    @Override
    public void initialize (URL url, ResourceBundle rb)
    {

    }


}
