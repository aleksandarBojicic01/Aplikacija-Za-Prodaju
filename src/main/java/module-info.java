module com.aco.aplikacijazaprodaju {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;

    exports com.aco.aplikacijazaprodaju;
    opens com.aco.aplikacijazaprodaju to javafx.fxml;

    exports com.aco.aplikacijazaprodaju.model;
    opens com.aco.aplikacijazaprodaju.model to javafx.fxml;

    exports com.aco.aplikacijazaprodaju.kontroler;
    opens com.aco.aplikacijazaprodaju.kontroler to javafx.fxml;
}