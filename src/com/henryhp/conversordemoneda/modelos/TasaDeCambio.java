package com.henryhp.conversordemoneda.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TasaDeCambio {
    private String resultado;
    private String ultimaFechaDeActualizacion;
    private String proximaFechaDeActuaclizacion;
    private String monedaBase;
    private String monedaObjetivo;
    private double tasaDeConversion;
    private LocalDateTime fechaHora;
    private double totalCambiado;
    private double monto;

    public TasaDeCambio(String resultado, String ultimaFechaDeActualizacion, String proximaFechaDeActuaclizacion, String monedaBase, String monedaObjetivo, double tasaDeConversion, double valorDeCambio) {
        this.resultado = resultado;
        this.ultimaFechaDeActualizacion = ultimaFechaDeActualizacion;
        this.proximaFechaDeActuaclizacion = proximaFechaDeActuaclizacion;
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.tasaDeConversion = tasaDeConversion;
    }

    public TasaDeCambio(RespuestaTasaDeCambio respuesta) {
        this.resultado = respuesta.result();
        this.ultimaFechaDeActualizacion = respuesta.time_last_update_utc();
        this.proximaFechaDeActuaclizacion = respuesta.time_next_update_utc();
        this.monedaBase = respuesta.base_code();
        this.monedaObjetivo = respuesta.target_code();
        this.tasaDeConversion = respuesta.conversion_rate();
        this.fechaHora = LocalDateTime.now();
    }

    public double getTasaDeConversion() {
        return tasaDeConversion;
    }

    public double getTotalCambiado(double monto){
        this.monto = monto;
        this.totalCambiado = getTasaDeConversion() * monto;
        return totalCambiado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public double getMonto() {
        return monto;
    }

    public double getTotalCambiado() {
        return totalCambiado;
    }

    public String getFechaHoraFormateada(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        return this.fechaHora.format(formato);
    }

    public String getResultado() {
        return resultado;
    }

    public String getUltimaFechaDeActualizacion() {
        return ultimaFechaDeActualizacion;
    }

    public String getProximaFechaDeActuaclizacion() {
        return proximaFechaDeActuaclizacion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    @Override
    public String toString() {
        return "\n=== Resultado de Conversión ===" +
                "\nMonto ingresado: " + monto + " [" + monedaBase + "]" +
                "\nTasa de conversión: " + tasaDeConversion +
                "\nTotal convertido: " + totalCambiado + " [" + monedaObjetivo + "]" +
                "\nFecha: " + getFechaHoraFormateada() +
                "\n-------------------------------";
    }

    public String stringForJson() {
        return "{" +
                "montoIngresado: " + this.monto+
                "monedaBase: " + this.monedaBase  +
                "tasaDeConversión: " + this.tasaDeConversion +
                "monedaObjetivo: " + this.monedaObjetivo +
                "totalConvertido: " + this.totalCambiado +
                "Fecha: " + this.fechaHora +
                "}";
    }
}
