package com.example.symulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApplication extends Application {
    private Mysql sql;
    private static MainApplication instance;


    private void setupSql() {

        String host = "51.195.118.42";
        String username = "kasia";
        String password = "1234";
        String port =  "3306";
        String database = "kpop";

        boolean ssl = false;
        this.sql = new Mysql(host, username, password, database, port, ssl);
    }

    @Override
    public void start(Stage stage) throws IOException {
        setupSql();
        instance = this;

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("scena1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 550);
        stage.setTitle("Kpop company owner SIMULATOR");
        stage.setScene(scene);
        scene.getStylesheets().add("symulator.css");
        stage.show();
    }

    public Mysql getSql() {
        return sql;
    }

    public static MainApplication getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch();
    }
}