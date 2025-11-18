package com.henryhp.conversordemoneda.modelos;

public record MuestraMenu() {
    public String mostrarMenu() {
        return  "===========================================\n" +
                "Elija una opción de cambio de moneda:\n\n" +
                "1) Dólar a Peso colombiano.\n" +
                "2) Euro a Peso colombiano.\n" +
                "3) Dólar chino a Peso colombiano.\n" +
                "4) Peso colombiano a Peso Chileno.\n" +
                "5) Peso colombiano a Reales.\n" +
                "6) Peso mexícano a Reales.\n" +
                "7) Ver historial de cambio.\n" +
                "8) Salir.";
    }
}
