package com.henryhp.conversordemoneda.modelos;

public class SeleccionaMoneda {

    private String monedas;

    public String retornaMonedaSeleccionada(int opcion){
        switch (opcion){
            // Dólar a peso colombiano
            case 1:
                return monedas = "USD/COP";
            case 2:
                // Euro a peso colombiano
                return monedas = "EUR/COP";
            case 3:
                // Dólar chino a peso colombiano
                return monedas = "HKD/COP";
            case 4:
                // Peso colombiano a peso chileno
                return monedas = "COP/CLP";
            case 5:
                // Peso colombiano a reales
                return monedas = "COP/BRL";
            case 6:
                // Peso mexicano a reales
                return monedas = "MXN/BRL";
            case 7:
                return "historial";
            case 8:
                return "salir";
            default:
                return null;
        }
    }
}
