package gestorcobranza;

import java.time.LocalDate;

public class PromesaPago {
    private Cliente cliente;
    private LocalDate fechaPago;
    private double cantidad;
    private boolean vencida;

    public PromesaPago(Cliente cliente, LocalDate fechaPago, double cantidad, boolean vencida) {
        this.cliente = cliente;
        this.fechaPago = fechaPago;
        this.cantidad = cantidad;
        this.vencida = vencida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isVencida() {
        return vencida;
    }

    public void setVencida(boolean vencida) {
        this.vencida = vencida;
    }

    public boolean estaVencida() {
        return LocalDate.now().isAfter(fechaPago);
    }
}
