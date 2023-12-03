package gestorcobranza;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCobranza {
    private List<Cliente> clientes;
    private List<PromesaPago> promesasPagos;

    public SistemaCobranza() {
        this.clientes = new ArrayList<>();
        this.promesasPagos = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<PromesaPago> getPromesasPagos() {
        return promesasPagos;
    }

    public void setPromesasPagos(List<PromesaPago> promesasPagos) {
        this.promesasPagos = promesasPagos;
    }

    public void registrarPromesaPago(Cliente cliente, LocalDate fechaPago, double cantidad) {
        PromesaPago promesa = new PromesaPago(cliente, fechaPago, cantidad, false);
        promesasPagos.add(promesa);
    }

    public void mostrarClientesConPromesasVencidas() {
        for (PromesaPago promesa : promesasPagos) {
            if (promesa.estaVencida()) {
                System.out.println("Cliente: " + promesa.getCliente().getNombre() +
                        ", Fecha de pago: " + promesa.getFechaPago() +
                        ", Cantidad: " + promesa.getCantidad());
            }
        }
    }

    public void cambiarFechaPago(PromesaPago promesa, LocalDate nuevaFecha) {
        promesa.setFechaPago(nuevaFecha);
    }

    public void escalarPromesa(PromesaPago promesa) {
        promesa.setVencida(true);
    }

    public static void main(String[] args) {
        SistemaCobranza sistema = new SistemaCobranza();

        // Ejemplo: Agregar clientes
        Cliente cliente1 = new Cliente(1, "Cliente A");
        Cliente cliente2 = new Cliente(2, "Cliente B");

        sistema.getClientes().add(cliente1);
        sistema.getClientes().add(cliente2);

        // Obtener entrada del usuario usando Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de cuenta del cliente:");
        int numeroCliente = scanner.nextInt();
        Cliente clienteSeleccionado = null;

        // Buscar cliente por número de cuenta
        for (Cliente cliente : sistema.getClientes()) {
            if (cliente.getNumeroCliente() == numeroCliente) {
                clienteSeleccionado = cliente;
                break;
            }
        }

        if (clienteSeleccionado != null) {
            System.out.println("Ingrese la fecha de pago (YYYY-MM-DD):");
            String fechaPagoStr = scanner.next();
            LocalDate fechaPago = LocalDate.parse(fechaPagoStr);

            System.out.println("Ingrese la cantidad prometida de pago:");
            double cantidad = scanner.nextDouble();

            sistema.registrarPromesaPago(clienteSeleccionado, fechaPago, cantidad);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Cerrar el Scanner
        scanner.close();

        // Ejemplo: Registrar una promesa de pago
        sistema.registrarPromesaPago(cliente1, LocalDate.now().plusDays(5), 500.0);

        // Ejemplo: Mostrar clientes con promesas vencidas
        sistema.mostrarClientesConPromesasVencidas();

        // Ejemplo: Cambiar fecha de pago
        if (!sistema.getPromesasPagos().isEmpty()) {
            PromesaPago primeraPromesa = sistema.getPromesasPagos().get(0);
            sistema.cambiarFechaPago(primeraPromesa, LocalDate.now().plusDays(10));
        }

        // Ejemplo: Mostrar clientes con promesas vencidas después de cambiar la fecha
        sistema.mostrarClientesConPromesasVencidas();
    }
}
