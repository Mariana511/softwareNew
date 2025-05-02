package co.edu.poli.ProductoSoftware.modelo;

import java.util.Stack;

public class HistorialPrecio {
	private Stack<MementoPrecio> historial = new Stack<>();

    public void guardarMemento(MementoPrecio memento) {
        historial.push(memento);
    }

    public MementoPrecio obtenerUltimoEstado() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }

    public boolean tieneHistorial() {
        return !historial.isEmpty();
    }

}
