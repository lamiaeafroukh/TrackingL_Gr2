module ma.fstt.trackingl {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ma.fstt.trackingl to javafx.fxml;
    exports ma.fstt.trackingl;

    exports ma.fstt.model;


}