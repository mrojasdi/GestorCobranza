package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.PromesaPago;

public class GestorCobranzaController {
    private List<PromesaPago> promesas;

    public GestorCobranzaController() {
        this.promesas = new ArrayList<>();
        cargarPromesasDesdeCSV("C:\\Users\\mroja\\eclipse-jee-workspace\\GestorCobranza\\CarteraPTPvencidas.csv");
    }

    private void cargarPromesasDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                int numeroCliente = Integer.parseInt(datos[0]);
                Date fechaPago = dateFormat.parse(datos[1]);
                double cantidadPagar = Double.parseDouble(datos[2]);

                PromesaPago promesa = new PromesaPago(numeroCliente, fechaPago, cantidadPagar);
                promesas.add(promesa);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public List<PromesaPago> obtenerPromesasVencidas() {
        List<PromesaPago> promesasVencidas = new ArrayList<>();

        for (PromesaPago promesa : promesas) {
            if (promesa.estaVencida()) {
                promesasVencidas.add(promesa);
            }
        }

        return promesasVencidas;
    }
}
