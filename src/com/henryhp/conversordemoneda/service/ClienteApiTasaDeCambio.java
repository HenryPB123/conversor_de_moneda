
package com.henryhp.conversordemoneda.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.henryhp.conversordemoneda.modelos.RespuestaTasaDeCambio;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteApiTasaDeCambio {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String apikey;

    //obteniendo la apikey
    public ClienteApiTasaDeCambio() {
        this.apikey = CargaApiKey.loadApiKey();
        if (apikey == null) {
            System.out.println("Error al cargar la API key. Verifica el archivo que la contiene.");
        }
    }

    public RespuestaTasaDeCambio conexionCambiarMoneda(String monedas) throws IOException, InterruptedException {
        final String URL = "https://v6.exchangerate-api.com/v6/" + apikey + "/pair/" + monedas;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        if (!json.contains("success")) {
            System.out.println("Fallo el cambio de monedad");
            return null;
        }
        return gson.fromJson(json, RespuestaTasaDeCambio.class);
    }


}
