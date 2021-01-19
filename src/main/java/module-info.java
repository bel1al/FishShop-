module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.fishshop to javafx.fxml;
    exports org.fishshop;
}