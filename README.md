# 💱 Conversor de Moneda — Java + API ExchangeRate

Aplicación de consola desarrollada en **Java 17** que permite realizar conversiones de moneda en tiempo real utilizando la API de **ExchangeRate**.  
También genera un **historial de conversiones en formato JSON**, para consultar los resultados de operaciones pasadas.

---

## 🚀 Características principales

- Obtiene tasas de cambio reales desde la API ExchangeRate.
- Ofrece un menú interactivo para elegir diferentes pares de conversión.
- Permite ingresar cantidades a convertir con validación de errores.
- Muestra resultados detallados de cada conversión.
- Guarda automáticamente cada operación en un archivo JSON (`historialDeCambio.json`).
- Permite consultar un historial completo de las conversiones realizadas.
- Control de errores y validación de entradas del usuario.

---

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **HTTP Client (Java.net.http)**
- **JSON con Gson**
- **Manejo de archivos (FileWriter / FileReader)**
- Programación orientada a objetos (OOP)
- Validación de entrada con `Scanner`

---

## 📦 Estructura del proyecto

    src/
    └── com.henryhp.conversordemoneda/
    ├── principal/
    │ └── Principal.java
    ├── modelos/
    │ ├── MuestraMenu.java
    │ ├── SeleccionaMoneda.java
    │ ├── TasaDeCambio.java
    │ ├── RespuestaTasaDeCambio.java
    │ └── Historial.java
    ├── service/
    │ ├── CargaApiKey.java
    │ ├── ClienteApiTasaDeCambio.java
    │ └── GeneraArchivoHistorial.java
    └── util/
      ├── LocalDateTimeAdapter.java
      └── ValidarInput.java


---

## 📘 Cómo funciona

### 1️⃣ **Menú principal**
El sistema muestra un menú con varias posibles conversiones:

Bienvenino a tu aplicación CONVERSOR DE MONEDA
===========================================
Elija una opción de cambio de moneda:

1) Dólar a Peso colombiano.
2) Euro a Peso colombiano.
3) Dólar chino a Peso colombiano.
4) Peso colombiano a Peso Chileno.
5) Peso colombiano a Reales.
6) Peso mexícano a Reales.
7) Ver historial de cambio.
8) Salir.

---

### 2️⃣ **Validación de entrada**
La clase: ValidarInput
Asegura que el usuario no puede dejar campos vacíos ni ingresar valores inválidos.

---

### 3️⃣ **Consumo de la API**
La clase: ClienteApiTasaDeCambio
Realiza la conexión a la API ExchangeRate usando el nuevo HttpClient de Java.

---

### 4️⃣ **Proceso de conversión**
La clase: TasaDeCambio
Calcula el total convertido y devuelve una representación clara del resultado.
Respuesta:
### === Resultado de Conversión ===
    Monto ingresado: 1.0 [USD]
    Tasa de conversión: 3761.4279
    Total convertido: 3761.4279 [COP]
    Fecha: 17/11/2025 - 21:10:32
    -------------------------------

---

### 5️⃣ **Historial de conversiones**

Cada conversión se guarda automáticamente en un archivo: historialDeCambio.json
La clase: GeneraArchivoHistorial
Se encarga de generar el archivo y actualizarlo.
Formato guardado en archivo JSON:

    [
    {
    "resultado": "success",
    "ultimaFechaDeActualizacion": "Tue, 18 Nov 2025 00:00:01 +0000",
    "proximaFechaDeActuaclizacion": "Wed, 19 Nov 2025 00:00:01 +0000",
    "monedaBase": "EUR",
    "monedaObjetivo": "COP",
    "tasaDeConversion": 4362.0724,
    "fechaHora": "2025-11-17T21:30:02.765431400",
    "totalCambiado": 8724.1448,
    "monto": 2.0
    }
    ]

---

### 📥 Requisitos para ejecutar el proyecto
    ✔ Java 17 o superior
    ✔ Conexión a internet. Para consumir la API ExchangeRate.

---

### ▶️ Cómo ejecutar

    Clona este repositorio o descarga el proyecto.
    Abre una terminal dentro de la carpeta del proyecto.
    Compila:
        javac -d out $(find ./src -name "*.java")
    Ejecuta:
        java -cp out com.henryhp.conversordemoneda.principal.Principal

---

### 👨‍💻 Autor

Henry Peralta Briceño
Desarrollador web y móvil — Colombia
Proyecto creado como práctica de programación en Java, API REST y consumo de servicios externos.

---

### 📄 Licencia

MIT License — Libre para usar y modificar.