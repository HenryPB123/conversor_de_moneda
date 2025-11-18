package com.henryhp.conversordemoneda.util;

import java.util.Scanner;

public class ValidarInput {

    public int validarEntero(String mensaje , Scanner scanner){
        int numero;
        while (true){
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()){
                System.out.println("Error: No puede dejar el campo vacio. Intente de nuevo: ");
                continue;
            }

            try{
                numero = Integer.parseInt(entrada);
                break;
            }catch (NumberFormatException ex){
                System.out.println("Error: Debe ingresar un número valido.");
            }
        }
        return numero;
    }

    public double validarDecimal(String mensaje, Scanner scanner){
        double numero;
        while (true){
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();

            if (entrada.isEmpty()){
                System.out.println("Error: No puede dejar el campo vacio. Intente de nuevo: ");
                continue;
            }

            try{
                numero = Double.parseDouble(entrada);
                break;
            }catch (NumberFormatException ex){
                System.out.println("Error: Debe ingresar un número valido.");
            }
        }
        return numero;
    }
}
