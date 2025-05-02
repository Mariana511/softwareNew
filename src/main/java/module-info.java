module co.edu.poli.ProductoSoftware {
    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;

    exports co.edu.poli.ProductoSoftware.controlador;
    exports co.edu.poli.ProductoSoftware.modelo;
    exports co.edu.poli.ProductoSoftware.servicio;
    exports co.edu.poli.ProductoSoftware.vista;

    opens co.edu.poli.ProductoSoftware.vista to javafx.fxml;
    opens co.edu.poli.ProductoSoftware.controlador to javafx.fxml;
}