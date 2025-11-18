package com.henryhp.conversordemoneda.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CargaApiKey {

    public static String loadApiKey()  {
        Properties props = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream("config/apikey.properties")){
            props.load(fileInputStream);
            return props.getProperty("API_KEY");
        }catch (IOException ex) {
            System.out.println("Error al cargar la API key: " + ex.getMessage());
            return null;
        }
    }
}
