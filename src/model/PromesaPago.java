package model;

import java.util.Date;

public class PromesaPago {
    private int numeroCliente;
    private Date fechaPago;
    private double cantidadPagar;

    // Constructor con parámetros
    public PromesaPago(int numeroCliente, Date fechaPago, double cantidadPagar) {
        this.numeroCliente = numeroCliente;
        this.fechaPago = fechaPago;
        this.cantidadPagar = cantidadPagar;
    }

    // Otros métodos, getters y setters

    // Puedes agregar un método para determinar si la promesa de pago está vencida
    public boolean estaVencida() {
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Fecha actual: " + new Date());

        // Lógica para determinar si la fecha de pago está en el pasado
        return fechaPago.before(new Date());
    }
}
