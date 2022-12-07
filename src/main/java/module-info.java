module com.example.symulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.symulator to javafx.fxml;
    exports com.example.symulator;
}