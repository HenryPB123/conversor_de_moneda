package com.henryhp.conversordemoneda.principal;
import com.henryhp.conversordemoneda.modelos.*;
import com.henryhp.conversordemoneda.service.ClienteApiTasaDeCambio;
import com.henryhp.conversordemoneda.service.GeneraArchivoHistorial;
import com.henryhp.conversordemoneda.util.ValidarInput;

import java.io.IOException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        ClienteApiTasaDeCambio conexion = new ClienteApiTasaDeCambio();
        MuestraMenu menu = new MuestraMenu();
        ValidarInput validador = new ValidarInput();
        SeleccionaMoneda monedaSeleccionada = new SeleccionaMoneda();
        Historial historial = new Historial();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBienvenino a tu aplicación CONVERSOR DE MONEDA");

        while(true) {
            int opcion = validador.validarEntero(menu.mostrarMenu(), scanner);

           String retornoParMoneda = monedaSeleccionada.retornaMonedaSeleccionada(opcion);
            if (retornoParMoneda == null) {
                System.out.println("La opción que elegiste no está disponible. Prueba con otra!");
                continue;
            }
            if (retornoParMoneda.contains("salir")) {
                System.out.println("Gracias por usar nuestro servicio. Te esperamos pronto!!");
                break;
            }  if (retornoParMoneda.contains("historial")) {
                historial.mostrarHistorial();
                continue;
            }

            RespuestaTasaDeCambio respuestaTasaDeCambio = conexion.conexionCambiarMoneda(retornoParMoneda);
            TasaDeCambio cambio = new TasaDeCambio(respuestaTasaDeCambio);

           double cantidadParaCambio = validador.validarDecimal("\nIngresa el monto que deseas cambiar: ", scanner);
            cambio.getTotalCambiado(cantidadParaCambio);
            historial.agregarAlHistorial(cambio);
            System.out.println(cambio);

            try{
                GeneraArchivoHistorial generador = new GeneraArchivoHistorial(historial);
                generador.guardarJson("historialDeCambio.json");

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }
}
