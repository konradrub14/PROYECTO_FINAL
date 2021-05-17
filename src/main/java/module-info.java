module com.mycompany.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.proyecto to javafx.fxml;
    exports com.mycompany.proyecto;
}
