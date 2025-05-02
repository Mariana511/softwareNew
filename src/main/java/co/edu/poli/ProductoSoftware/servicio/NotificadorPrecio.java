package co.edu.poli.ProductoSoftware.servicio;

import java.util.ArrayList;
import java.util.List;

public class NotificadorPrecio {
	
	private List<ObservadorProducto> productosInscritos = new ArrayList<>();

    public void suscribir(ObservadorProducto producto) {
        productosInscritos.add(producto);
    }

    public void desuscribir(ObservadorProducto producto) {
        productosInscritos.remove(producto);
    }

    public void notificar(double porcentaje) {
        for (ObservadorProducto producto : productosInscritos) {
            producto.actualizarPrecio(porcentaje);
        }
    }

}
