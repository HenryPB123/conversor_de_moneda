package com.henryhp.conversordemoneda.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.henryhp.conversordemoneda.modelos.Historial;
import com.henryhp.conversordemoneda.util.LocalDateTimeAdapter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeneraArchivoHistorial {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();
    private final Historial historial;

    public GeneraArchivoHistorial(Historial historial) {
        this.historial = historial;
    }

    public void guardarJson(String archivo) throws IOException {
        try (FileWriter writer = new FileWriter(archivo)){
            writer.write(gson.toJson(historial.getHistorial()));

//            La siguiente línea de código se escribiría si fuera un try-catch normal,
//            pero como es un try-with-resources, el try cierra conexiones automáticamente
//            sin necesidad algún método.close()
            writer.close();
        }

    }
}
