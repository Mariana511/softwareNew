package co.edu.poli.ProductoSoftware.modelo;

import co.edu.poli.ProductoSoftware.servicio.ObservadorProducto;

public class Producto implements ObservadorProducto {
	private String nombre;
    private double precioActual;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precioActual = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double nuevoPrecio) {
        this.precioActual = nuevoPrecio;
    }

    // Crea el Memento
    public MementoPrecio guardarEstado() {
        return new MementoPrecio(precioActual);
    }

    // Restaura desde el Memento
    public void restaurarEstado(MementoPrecio memento) {
        this.precioActual = memento.getPrecio();
    }

    @Override
    public String toString() {
        return nombre + " - $" + precioActual;
    }

	@Override
	public void actualizarPrecio(double porcentaje) {
		precioActual += precioActual * (porcentaje / 100.0);
	}
    

}
