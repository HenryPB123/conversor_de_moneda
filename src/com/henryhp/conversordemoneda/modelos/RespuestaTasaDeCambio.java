package com.henryhp.conversordemoneda.modelos;

public record RespuestaTasaDeCambio(String result, String time_last_update_utc, String time_next_update_utc, String base_code, String target_code, double conversion_rate) {
}
