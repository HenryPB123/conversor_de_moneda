package com.henryhp.conversordemoneda.modelos;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final List<TasaDeCambio> historial = new ArrayList<>();

    public void agregarAlHistorial(TasaDeCambio registro){
        this.historial.add(registro);
    }

    public List<TasaDeCambio> getHistorial() {
        return historial;
    }

    public void mostrarHistorial(){

        if(historial.isEmpty()){
            System.out.println("No hay registros en el historial.");
            return;
        }
        System.out.println("\n ========== HISTORIAL DE CONVERSIONES ============");
        for (TasaDeCambio item : historial){
            System.out.println(item);
        }
        System.out.println("------------------------------------------------");
    }

}
