package com.example.symulator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ZarzadzanieController implements Initializable {

    @FXML public Pane panel_tlo;
    @FXML public Button przycisk_wybierz;
    @FXML public TableView lista_zespoly;
    @FXML public TableColumn nazwaColumn;

    public static String nazwa = "";
    public String nick;


    Mysql baza = MainApplication.getInstance().getSql();

    @FXML
    public void wybierzAction(ActionEvent actionEvent) throws IOException {
        nazwa = (String) lista_zespoly.getSelectionModel().getSelectedItem();
        System.out.println("Nazwa: "+nazwa);

        Parent root = FXMLLoader.load(getClass().getResource("scena2.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Grupa> grupy = FXCollections.observableArrayList();
        String nazwa;

        nick = Scena2Controller.nick;

        try
        {
            ResultSet wynik = baza.getResult("SELECT * FROM grupy WHERE wytwornia='"+nick+"'");
            while(wynik.next())
            {
                nazwa = wynik.getString(2);
                grupy.add(new Grupa(nazwa));
            }
        }
        catch (SQLException e) {
            System.out.println("Nieprawidłowe zapytanie!!!");
        }

        lista_zespoly.itemsProperty().setValue(grupy);
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<Grupa, String>("nazwa"));
    }

}
