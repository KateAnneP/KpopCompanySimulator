package com.example.symulator;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Scena2Controller implements Initializable {

    @FXML public TextField pole_ilosc_piosenek;
    @FXML public TextField pole_fani;
    @FXML public TextField pole_dni_od_comebacku;
    @FXML public TextField pole_hp;
    @FXML public TextField pole_dni_kontrakt;
    @FXML public TextField pole_nazwa_zesp;
    @FXML public TableView tabela_idole;
    @FXML public TextField pole_nazwa_firmy;
    @FXML public TextField pole_dni_od_startu;
    @FXML public TextField pole_pieniadze;
    @FXML public TableColumn ImieColumn;
    @FXML public TableColumn WiekColumn;
    @FXML public TableColumn PozycjaColumn;
    @FXML public Button przycisk_promuj;
    @FXML public AnchorPane panel_prawy;
    @FXML public Button zamknij_program;
    @FXML public Button kolejny_dzien;
    @FXML public Label nazwa_wytworni;
    @FXML public Button menu_zadebiutuj_grupe;
    @FXML public Button menu_zarzadzaj_zespolami;
    @FXML public AnchorPane panel_lewy;
    @FXML public Button przycisk_zdissabnduj;
    @FXML public Button przycisk_wyslij_na_wakacje;
    @FXML public Button przycisk_zorganizuj_koncert;
    @FXML public Button przycisk_wydaj_album;

    Mysql baza = MainApplication.getInstance().getSql();

    public Double money;
    public int dni_od_startu;
    public int numer;
    public static String nick;

    public void wczytajScene2() {

        ArrayList<String> imiona1 = new ArrayList<String>();
        imiona1.add("Tae");
        imiona1.add("Won");
        imiona1.add("Jong");
        imiona1.add("Nae");
        imiona1.add("Ji");
        imiona1.add("Dah");
        imiona1.add("Chae");
        imiona1.add("Hee");
        imiona1.add("Sun");
        imiona1.add("Hyun");
        imiona1.add("Dong");
        imiona1.add("Je");
        imiona1.add("So");
        imiona1.add("Min");

        ArrayList<String> imiona2 = new ArrayList<String>();
        imiona2.add("yeon");
        imiona2.add("jin");
        imiona2.add("jong");
        imiona2.add("yun");
        imiona2.add("chul");
        imiona2.add("min");
        imiona2.add("yeong");
        imiona2.add("won");
        imiona2.add("hwa");
        imiona2.add("joon");
        imiona2.add("kyung");
        imiona2.add("rin");
        imiona2.add("mun");

        ArrayList<String> pozycje = new ArrayList<String>();
        pozycje.add("main vocal");
        pozycje.add("lead vocal");
        pozycje.add("sub-vocalist");
        pozycje.add("main dancer");
        pozycje.add("lead dancer");
        pozycje.add("visual");
        pozycje.add("center");

        grupy.add(new Grupa ("Astro"));

        if (numer == 1) {
            nick = Scena1bController.nick;
            pole_nazwa_firmy.setText(nick + " Entertainment");
        }
        else {
            nick = Scena1cController.nick;
            pole_nazwa_firmy.setText(nick + " Entertainment");
        }

        baza.update("INSERT INTO `grupy`(`nazwa`,`hp`,`dni`,`fani`,`piosenki`,`kontrakt`,`wytwornia`) VALUES ('"+grupy.get(0).getNazwa()+"','"+grupy.get(0).getHp()+"','"+grupy.get(0).getDni_od_comebacku()+"','"+grupy.get(0).getLiczba_fanow()+"','"+grupy.get(0).getIlosc_piosenek()+"','"+grupy.get(0).getKontrakt()+"','"+nick+"');");

        String imie, nick1, nick2, pozycja;
        int wiek, losowa3;
        Random generator = new Random();
        for (int i=0;i<5;i++)
        {
            int losowa1 = generator.nextInt(imiona1.toArray().length);
            int losowa2 = generator.nextInt(imiona2.toArray().length);
            nick1 = imiona1.get(losowa1);
            nick2 = imiona2.get(losowa2);
            imie = nick1+nick2;
            wiek = generator.nextInt(10)+15;
            if (i==0)
                pozycja = "leader";
            else
            {
                losowa3 = generator.nextInt(pozycje.toArray().length);
                pozycja = pozycje.get(losowa3);
            }
            idole.add(new Idol(imie, wiek, pozycja, "Astro"));
        }

        for (Idol i: idole)
        {
            if (i.getGrupa() == "Astro") {
                System.out.println(i.getNick() + ", " + i.getPozycja() + ", " + i.getWiek());
                baza.update("INSERT INTO `idole`(`imie`,`wiek`,`pozycja`,`grupa`,`wytwornia`) VALUES ('"+i.getNick()+"','"+i.getWiek()+"','"+i.getPozycja()+"','"+i.getGrupa()+"','"+nick+"');");
            }
        }

        try {
            ResultSet wynik = baza.getResult("SELECT * FROM users WHERE nick='" + nick + "'");
            wynik.next();
            //System.out.println("Dni:"+wynik.getInt(5));

            money = wynik.getDouble("fundusze");
            pole_pieniadze.setText(money + "$");
            dni_od_startu = wynik.getInt("dni");
            pole_dni_od_startu.setText(String.valueOf(dni_od_startu));
        }
        catch (SQLException e)
        {
            System.out.println("Błędny wynik zapytania!!!");
        }


        pole_dni_kontrakt.setText(String.valueOf(grupy.get(0).getKontrakt()));
        pole_dni_od_comebacku.setText(String.valueOf(grupy.get(0).getDni_od_comebacku()));
        pole_fani.setText(String.valueOf(grupy.get(0).getLiczba_fanow()));
        pole_hp.setText(String.valueOf(grupy.get(0).getHp()));
        pole_ilosc_piosenek.setText(String.valueOf(grupy.get(0).getIlosc_piosenek()));
        pole_nazwa_zesp.setText(String.valueOf(grupy.get(0).getNazwa()));

        tabela_idole.itemsProperty().setValue(idole);
        ImieColumn.setCellValueFactory(new PropertyValueFactory<Idol, String>("nick"));
        WiekColumn.setCellValueFactory(new PropertyValueFactory<Idol, Integer>("wiek"));
        PozycjaColumn.setCellValueFactory(new PropertyValueFactory<Idol, String>("pozycja"));

    }

    @FXML
    public void wyswietlanie() {
        String imie, pozycja, grupa;
        if (ZarzadzanieController.nazwa != "") {
            grupa = ZarzadzanieController.nazwa;
        }
        else
        {
            grupa = "Astro";
        }
        int wiek;
        ObservableList<Idol> idole_z_grupy = FXCollections.observableArrayList();
        System.out.println("Nazwa: "+grupa);

        if (numer == 1) {
            nick = Scena1bController.nick;
            pole_nazwa_firmy.setText(nick + " Entertainment");
        }
        else {
            nick = Scena1cController.nick;
            pole_nazwa_firmy.setText(nick + " Entertainment");
        }

        try {
            ResultSet wynik = baza.getResult("SELECT * FROM users WHERE nick='" + nick + "'");
            wynik.next();
            //System.out.println("Dni:"+wynik.getInt(5));

            money = wynik.getDouble("fundusze");
            pole_pieniadze.setText(money + "$");
            dni_od_startu = wynik.getInt("dni");
            pole_dni_od_startu.setText(String.valueOf(dni_od_startu));
        }
        catch (SQLException e)
        {
            System.out.println("Błędny wynik zapytania!!!");
        }

        try {
            ResultSet wynik2 = baza.getResult("SELECT * FROM grupy WHERE wytwornia='"+ nick +"' AND nazwa='"+grupa+"'");
            wynik2.next();
            grupa = wynik2.getString("nazwa");
            pole_nazwa_zesp.setText(grupa);
            int kontrakt = wynik2.getInt(7);
            pole_dni_kontrakt.setText(String.valueOf(kontrakt));
            int dni = wynik2.getInt(4);
            pole_dni_od_comebacku.setText(String.valueOf(dni));
            int fani = wynik2.getInt(5);
            pole_fani.setText(String.valueOf(fani));
            int hp = wynik2.getInt(3);
            pole_hp.setText(String.valueOf(hp));
            int piosenki = wynik2.getInt(6);
            pole_ilosc_piosenek.setText(String.valueOf(piosenki));
            try {
                ResultSet wynik3 = baza.getResult("SELECT * FROM idole WHERE grupa='"+ grupa +"' AND wytwornia ='"+nick+"'");
                while(wynik3.next())
                {
                    imie = wynik3.getString("imie");
                    wiek = wynik3.getInt("wiek");
                    pozycja = wynik3.getString("pozycja");
                    idole_z_grupy.add(new Idol(imie,wiek,pozycja,grupa));
                }
            }
            catch (SQLException e)
            {
                System.out.println("Błędny wynik zapytania!!!");
            }
        }
        catch (SQLException e)
        {
            System.out.println("Błędny wynik zapytania!!!");
        }



        tabela_idole.itemsProperty().setValue(idole_z_grupy);
        ImieColumn.setCellValueFactory(new PropertyValueFactory<Idol, String>("nick"));
        WiekColumn.setCellValueFactory(new PropertyValueFactory<Idol, Integer>("wiek"));
        PozycjaColumn.setCellValueFactory(new PropertyValueFactory<Idol, String>("pozycja"));


    }

    ObservableList<Idol> idole = FXCollections.observableArrayList();
    ObservableList<Grupa> grupy = FXCollections.observableArrayList();

    @FXML
    private void zamknijAplikacjeAction (ActionEvent actionEvent)
    {
        Platform.exit();
    }

    @FXML
    public void promujAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("promuj.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();

        Random losuj = new Random();
        /*
        if (PromujController.wybor == 1 )
        {
            grupy.get(0).setHp(grupy.get(0).getHp() - 100);
        }
        else if (PromujController.wybor == 2)
        {
            grupy.get(0).setHp(grupy.get(0).getHp() - 200);
        }
        else if (PromujController.wybor == 3)
        {
            grupy.get(0).setHp(grupy.get(0).getHp() - 200);
        }
        else if (PromujController.wybor == 4)
        {
            grupy.get(0).setHp(grupy.get(0).getHp() - 300);
        }

        if(grupy.get(0).getDni_od_comebacku() <= 30) {
            int x = losuj.nextInt(300);
            grupy.get(0).setLiczba_fanow(grupy.get(0).getLiczba_fanow() + x);
        }
        else if (grupy.get(0).getDni_od_comebacku() > 30 && grupy.get(0).getDni_od_comebacku() < 50)
        {
            int x = losuj.nextInt(100);
            grupy.get(0).setLiczba_fanow(grupy.get(0).getLiczba_fanow() + x);
        }
        else {
            int x = losuj.nextInt(50);
            grupy.get(0).setLiczba_fanow(grupy.get(0).getLiczba_fanow() + x);
        }

        pole_fani.setText(String.valueOf(grupy.get(0).getLiczba_fanow()));
        pole_hp.setText(String.valueOf(grupy.get(0).getHp()));
        */
    }

    @FXML
    public void wydajAlbumAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("wydajAlbum.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @FXML
    public void koncertAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("koncert.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @FXML
    public void wakacjeAction(ActionEvent actionEvent) {

    }

    @FXML
    public void disbandAction(ActionEvent actionEvent) {
    }

    @FXML
    public void kolejnyDzienAction(ActionEvent actionEvent) {
        //setMoney(getMoney() - 100);
        //pole_pieniadze.setText(String.valueOf(getMoney()));
        //setDni_od_startu(getDni_od_startu() + 1);
        //pole_dni_od_startu.setText(String.valueOf(getDni_od_startu()));
        if (grupy.get(0).getHp() < 960)
            grupy.get(0).setHp(grupy.get(0).getHp() + 40);
        else if (grupy.get(0).getHp() >= 960)
            grupy.get(0).setHp(1000);
        pole_hp.setText(String.valueOf(grupy.get(0).getHp()));
        grupy.get(0).setKontrakt(grupy.get(0).getKontrakt() - 1);
        pole_dni_kontrakt.setText(String.valueOf(grupy.get(0).getKontrakt()));
        grupy.get(0).setDni_od_comebacku(grupy.get(0).getDni_od_comebacku() + 1);
        pole_dni_od_comebacku.setText(String.valueOf(grupy.get(0).getDni_od_comebacku()));

    }


    public void zarzadajAction(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("zarzadzanie.fxml"));
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Kpop company owner SIMULATOR");
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        if (Scena1bController.numer == 1)
        {
            numer = 1;
            if (Scena1bController.pierwszy == true) {
                wczytajScene2();
                Scena1bController.pierwszy = false;
            }
            else
            {
                wyswietlanie();
            }
        }
        else
        {
            numer = 2;
            wyswietlanie();
        }

    }


}
