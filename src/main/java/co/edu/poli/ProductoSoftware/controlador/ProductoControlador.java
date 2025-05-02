package co.edu.poli.ProductoSoftware.controlador;

import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ProductoSoftware.modelo.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import co.edu.poli.ProductoSoftware.servicio.NotificadorPrecio;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ProductoControlador {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;
    
    @FXML
    private TextField txtPorcentaje;
    
    @FXML
    private ListView<String> listaProductos;
    
    

    
    private List<Producto> productos = new ArrayList<>();
    private NotificadorPrecio notificador = new NotificadorPrecio();
    
    @FXML
    void clickAgregarProducto(ActionEvent event) {
    	 try {
             String nombre = txtNombre.getText();
             double precio = Double.parseDouble(txtPrecio.getText());

             Producto producto = new Producto(nombre, precio);
             productos.add(producto);
             notificador.suscribir(producto);

             listaProductos.getItems().add(producto.toString());
             txtNombre.clear();
             txtPrecio.clear();
         } catch (Exception e) {
             mostrarAlerta("Error", "Datos inválidos. Verifica el nombre y precio.");
         }

    }

    @FXML
    void clickNotificarCambio(ActionEvent event) {
    	 try {
             double porcentaje = Double.parseDouble(txtPorcentaje.getText());

             for (Producto p : productos) {
                 p.getHistorial().guardarMemento(p.guardarEstado());
             }

             notificador.notificar(porcentaje);

             listaProductos.getItems().clear();
             for (Producto p : productos) {
                 listaProductos.getItems().add(p.toString());
             }

         } catch (Exception e) {
             mostrarAlerta("Error", "Porcentaje inválido.");
         }

    }

    @FXML
    void clickRestaurarPrecioAnterior(ActionEvent event) {
    	 for (Producto p : productos) {
             if (p.getHistorial().tieneHistorial()) {
                 p.restaurarEstado(p.getHistorial().obtenerUltimoEstado());
             }
         }

         listaProductos.getItems().clear();
         for (Producto p : productos) {
             listaProductos.getItems().add(p.toString());
         }
     }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    	
    }

